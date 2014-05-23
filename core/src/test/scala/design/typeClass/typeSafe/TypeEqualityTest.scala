package design.typeClass.typeSafe

import org.scalatest.FunSuite

class TypeEqualityTest extends FunSuite {

  test("compare types without using parameter type") {

    trait Fruit {
      def compare(x: Fruit): Boolean = true
    }

    class Apple extends Fruit
    class Orange extends Fruit

    val apple = new Apple
    val orange = new Orange

    apple.compare(orange)

  }

  test("compare type using parameter type") {
    trait Fruit[T <: Fruit[T]] {
      def compare(x: Fruit[T]): Boolean = true
    }

    class Apple extends Fruit[Apple]
    class Orange extends Fruit[Orange]

    class FujiApple extends Apple

    val apple = new Apple
    val orange = new Orange

    val fujiApple = new FujiApple

    apple.compare(fujiApple)

  }

}
