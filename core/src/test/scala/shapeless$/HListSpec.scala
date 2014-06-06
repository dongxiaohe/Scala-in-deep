package shapeless$

import shapeless._
import org.scalatest.FunSuite
import java.util.Date
import shapeless.ops.hlist.Selector

class HListSpec extends FunSuite {

  test("HList") {

    trait Service[T<: HList] {
       def doStuff: Unit
    }

    class CreateService extends Service[CreateCommand :: HNil] {
      override def doStuff: Unit = {
        println("create....")
      }
    }

//    implicit def convert(x: Int :: String :: HNil): String :: Int :: HNil = x.tail.head :: x.head :: HNil

//    implicit def convert[T](x: T): T :: HNil = x :: HNil
//    implicit def convert[T](x: T): Date = new Date



    class UpdateService extends Service[UpdateCommand :: HNil] {
      override def doStuff: Unit = {
        println("update....")
      }
    }

    implicit val createService = new CreateService
    implicit val updateService = new UpdateService


    def takeCommandCombination[T <: HList](x: T)(implicit service: Service[T]) {
      service.doStuff
    }

    def dispatch[T <: CreateCommand](x: T) = {
      val hlistCommand: CreateCommand :: HNil = x :: HNil

      takeCommandCombination(hlistCommand)
    }

    val command = new CreateCommand

    dispatch(command)

//    println("String" :: HNil)
//    println(1 :: HNil)

  }


  test("list") {
      trait Service[HList] {
        def doStuff(): Unit
      }

      class CreateUpdateService extends Service[CreateCommand :: UpdateCommand :: HNil] {
        override def doStuff(): Unit = println("create.......")
      }
      class DeleteService extends Service[DeleteCommand :: HNil] {
        override def doStuff(): Unit = println("update........")
      }

      implicit val createUpdateService = new CreateUpdateService
//      implicit val deleteService = new DeleteService[DeleteCommand :: HNil]

      def dispatchCommand[T <: Command, W <: HList](x: T)(implicit service: Service[W]) = {
        service.doStuff()
      }

      dispatchCommand(new CreateCommand)

  }













  test("convert service[Command] to service[HList] in which HList contains Command") {


    class A

    class B

    class C

//    trait Service[HList] {
//      def doStuff(): Unit
//    }

//    class ServiceAB extends Service[A :: B :: HNil] {
//      override def doStuff(): Unit = println("handling a b")
//    }
//
//    class ServiceC extends Service[C :: HNil] {
//      override def doStuff(): Unit = println("handling c")
//    }
//
//    implicit val serviceAB = new ServiceAB
//    implicit val serviceC = new ServiceC

    trait Service[L <: HList, U] { def doStuff(): Unit }


    trait lowPriority {
      implicit def otherwise[L <: HList, U] =
        new Service[L, U] {
          def doStuff(): Unit = println("handling otherwise")
        }
    }


    object Service extends lowPriority {
      implicit def ab[L <: HList, U](implicit e: L =:= (A :: B :: HNil), s: Selector[L, U]) =
        new Service[L, U] {
          def doStuff(): Unit = println("handling a b")
        }

      implicit def c[L <: HList, U](implicit e: L =:= (C :: HNil), s: Selector[L, U]) =
        new Service[L, U] {
          def doStuff(): Unit = println("handling c")
        }
    }

    def operate[T, W <: HList](x: T)(implicit service: Service[W, T]) = {
      service.doStuff()
    }

    operate(new C)

  }
























}

trait Command

class CreateCommand extends Command
class UpdateCommand extends Command
class DeleteCommand extends Command