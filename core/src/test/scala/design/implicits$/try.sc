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




