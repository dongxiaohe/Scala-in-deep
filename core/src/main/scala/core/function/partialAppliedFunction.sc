//method
def add(x: Int, y: Int) = x + y
val x3 = add(3, _: Int)
x3(4)

//type
class Test[F[_]]

type IntEither[T] = Either[Int, T]

class Foo
type FooAlias = {
  type FooEither[T] = Either[Foo, T]
}
class EitherTest extends Test[IntEither]
class FooTest extends Test[FooAlias#FooEither]
new Test[({type T[X] = Either[Int, X]})#T]

class Bar[T] {

}

val test = new Bar[String]

val result = test.isInstanceOf[Bar[Int]]