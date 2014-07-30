def foo(x: Int): String = "foo"
def bar(x: Int, y: Int): String = "bar"
def foobar(x: Int, y: Int, z: Int): String = "foobar"

sealed trait FuncRes[T] {
  def resolve : T
}

object FuncRes {

  implicit def f1[T, R](f: T => R) = {
    new FuncRes[T => R] {
      override def resolve: (T) => R = f
    }
  }

  implicit def f2[T1, T2, R](f: (T1, T2) => R) = {
    new FuncRes[(T1, T2) => R] {
      override def resolve: (T1, T2) => R = f
    }
  }

  implicit def f3[T1, T2, T3, R](f: (T1, T2, T3) => R) = {
    new FuncRes[(T1, T2, T3) => R] {
      override def resolve: (T1, T2, T3) => R = f
    }
  }

}

def execute[T](f: FuncRes[T]) = f.resolve

execute(foobar _)(1, 2, 3)
