class A

class C extends A

class Container[T] {

  def take(x: T) = {

  }

}
def doStuff[T <: A](container: Container[T]): Unit = {

}

doStuff(new Container[A])
doStuff(new Container[C])

List(1,2,3).map