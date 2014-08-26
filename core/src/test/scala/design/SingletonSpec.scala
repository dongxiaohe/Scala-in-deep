package design

import org.scalatest.FunSuite

class SingletonSpec extends FunSuite {



  test("singleton") {


    trait OnlyForObjects  { this: Singleton =>
    }

    object Foo extends OnlyForObjects


//    class Bar extends OnlyForObjects

  }
}
