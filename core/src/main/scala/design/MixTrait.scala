package design

object MixTrait {

  def main(args: Array[String]) = {

    trait A {
      def nothing() = {}
    }
    trait B {
      self: A =>

      def doStuff() = self.nothing()
    }

    object main extends A with B

    main.doStuff()

    trait Box { def put(num: Int): Int = { println("Put "+num); num} }
    trait FunctionBox extends Box { self =>
      def fn: (Int => Int)
      def andThen(fb: FunctionBox) = new FunctionBox {
        def fn = self.fn andThen fb.fn
      }
      override def put(num: Int): Int = { super.put(fn(num)) }
    }
    object DoubleBox extends FunctionBox {
      val fn = (x: Int) => 2*x
    }

    object TrippleBox extends FunctionBox {
      val fn = (x: Int) => 3*x
    }


    val MyBox = DoubleBox andThen DoubleBox andThen DoubleBox andThen TrippleBox
    println(MyBox.put(3))


  }

}
