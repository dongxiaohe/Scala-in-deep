package design.implicits$.scope.common

import design.implicits$.scope.Bar._


class Common



object MainClass {


  def main(x: Array[String]) = {

    import design.implicits$.scope.Foo3._

    new Common().doStuff()

    println("123")
  }

}