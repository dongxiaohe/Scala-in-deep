package design.implicits$.scope

import design.implicits$.scope.common.Common

class Bar {

  def doStuff(): Unit = {println("123")}
}

object Bar {

  implicit def take(x: Common): Bar = new Bar

}

object Foo3 {

  implicit def take(x: Common): Foo3 = new Foo3

}

class Foo3 {

  def doStuff(): Unit = {println("hello world")}

}

