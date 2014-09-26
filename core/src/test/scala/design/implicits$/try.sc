import scala.collection.mutable.ListBuffer

implicit def enhanceWithContainsDuplicates[T](s:List[T]) = new {
  def containsDuplicates = (s.distinct.size != s.size)
}
assert(List(1,2,2,3).containsDuplicates)
assert(!List("a","b","c").containsDuplicates)

def thing: Int = {
  if (false)
    42 // : Int
  else
    throw new Exception("Whoops!") // : Nothing
}
class Fruit
case class Apple() extends Fruit
case class Orange() extends Fruit
val l1: List[Apple] = Apple() :: Nil
val l2: List[Fruit] = Orange() :: l1

val foo = Array(1,2,3)

4 +: foo
val set: Set[Fruit] = Set(Apple())
def doStuff(x: Set[Fruit]) = {}

val appleSet: Set[Apple] = Set(Apple())

//doStuff(appleSet)

class Thing[+A]

val t: Thing[Fruit] = new Thing[Apple]

class A {
  def getMsgNum = 1
}

class B {
  def getMsgNum = 2
}

class C {
  def getMsgNum = 3
}

trait Adaptor[T] {
  def getMsgNum: Int
}

class AdaptorA(t: A) extends Adaptor[A] {
  def getMsgNum = t.getMsgNum
}

class AdaptorB(t: B) extends Adaptor[B] {
  def getMsgNum = t.getMsgNum
}

class AdaptorC(t: C) extends Adaptor[C] {
  def getMsgNum = t.getMsgNum
}

def getMsgNum[T](t: Adaptor[T]) = t.getMsgNum
getMsgNum(new AdaptorA(new A))
getMsgNum(new AdaptorB(new B))
getMsgNum(new AdaptorC(new C))

//Array(1,2,3).to[ListBuffer]
//
//def number5()={
//  println("number 5 starting")
//  println("number 5 exiting")
//  5
//}
//
//def func: () => Int = number5
//
//def giveMeCallByNameParameter(f: =>Int)={
//  println("starting")
//  f
//  println("exiting")
//}
//giveMeCallByNameParameter(func)
//def giveMeAnotherFunction(f: ()=>Int)={
//  println("starting")
//  f()
//  println("exiting")
//}
//
//giveMeAnotherFunction(func)

Seq(1,2,3).collectFirst{case foo if foo > 0 => foo}

def func(param: () => Unit): Unit = {
  param()
}

def functionAsParam(): Unit = {
  println("it works")
}
func(functionAsParam)
Seq(1,2,3,4,5,6,7).sliding(3).toList
def add(a: Int, b: Int, c: Int): Int = a + b + c
(add _).isInstanceOf[Function3[Int, Int, Int, Int]]
val result = (add _).curried
result(3)(3)
def whatever: Int => Int => Int => Int = t => {
  w => { r =>
    t + w + r
  }
}
def bar(x: Int): Int = x + 3
val function: (Int, Int, Int) => Int = (a, b, c) => result(a)(b)(c)
val bar: Int => Int = t => t
val array = Array(1, 2, 3)
Seq(1,2,3,4,5,6,7).slice(2,3).copyToArray(array, 3)
array.foreach(print)
