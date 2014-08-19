package play$

import org.scalatest.FunSuite
import play.api.libs.iteratee._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util._


class IterateeTest extends FunSuite {

  test("get iteratee") {

    val iter = Iteratee.fold(0){(total,elt:Int) => total + elt }  //Iteratee是Enumerator的迭代处理机
    val e1 = Enumerator(1, 234, 455, 987)                       //Enumerator为Iteratee准备原料
    val e2 = Enumerator(345, 123, 479, 187687)
    val conbind = e1.andThen(e2)                                   //将2个Enumerator合并
    conbind(Iteratee.foreach(println _))                              //1234455987345123479187687
    e1(iter)                                                                        //将e1送入迭代机
    val r1= e1.run(iter)                                                      //启动迭代机并工作
    val r2= e2.run(iter)


    val r3:Future[Int] = e1 run iter                                //total是一个Future占位值，
    r3 onComplete {                                                     //异步完成total计算
      case Success (t) => println("123")
      case Failure (t) => println("err")
    }

//    Thread.sleep(3000)

  }

}
