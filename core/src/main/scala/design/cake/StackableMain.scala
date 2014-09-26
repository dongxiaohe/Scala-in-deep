package design.cake

/**
 * Created by Danny.dong on 23/09/2014.
 */
object StackableMain {


  def main(args: Array[String]) {
//    object Sub6 extends Base with {
//      override def doStuff = {
//        println("Sub6 did stuff");
//        super.doStuff
//      }
//    } with WrapBase
//    Sub6.doStuff
  }
}

class Base extends WrapBase {
  override def doStuff = println("Base did stuff")
}

trait WrapBase {
  def doStuff = {
    println("WrapBase did stuff")
  }
}

