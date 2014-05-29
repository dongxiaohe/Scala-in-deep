package scalaz$.lens$

import org.scalatest.FunSuite

class LensSpec extends FunSuite {

  case class Lens[A,B](get: A => B, set: (A,B) => A) {
    def mod(a: A, f: B => B) : A = set(a, f(get(a)))
    def apply(a: A) = get(a)
    def andThen[C] (l: Lens[B, C]) : Lens[A, C] = Lens (
      a => l.get(get(a)), (a, c) => set(a, l.set(get(a), c))
    )
  }

  test("lens") {

    def stringToInt(x: String): Int = x.toInt + 3
    def stringWithInt(x: String, y: Int): String = x

    val result = Lens(stringToInt, stringWithInt)

    println(result("3"))
  }


  test("lens get the first element") {

    val first = Lens[(String, Int), Int](_._2, (com, first) => (com._1, first))

    println(first.get(("1", 2)))
    println(first.get(("3", 3)))
    println(first.set(("3", 4), 6))

  }

  test("toy example") {
    case class ToyBox(label: String, toy: Toy)
    sealed trait ToyCondition
    case object New extends ToyCondition // toy has just been bought or rarely played with
    case object Used extends ToyCondition // toy has obviously been played with
    case object Destroyed extends ToyCondition // teeth have really sunk in, its trash time

    case class Toy(condition: ToyCondition, daysOld: Int)

    def updateCondition(toyBox: ToyBox, newCondition: ToyCondition): ToyBox = {

      toyBox.copy(toy = toyBox.toy.copy(condition = newCondition))

    }

    val newToyBox = ToyBox("label", Toy(New, 3))

    val result: ToyBox = updateCondition(newToyBox, Used)

    println(result)

    val toyBoxLens: Lens[ToyBox, Toy] = Lens[ToyBox, Toy](_.toy, (toyBox, toy) => ToyBox(toyBox.label, toy))
    val conditionLens: Lens[Toy, ToyCondition] = Lens[Toy, ToyCondition](_.condition, (toy, condition) => Toy(condition, toy.daysOld))

    val usedToy: Toy = conditionLens.set(newToyBox.toy, Used)

    println(newToyBox.copy(toy = usedToy))

    println(toyBoxLens.set(newToyBox, conditionLens.set(newToyBox.toy, Used)))


    val lens: Lens[ToyBox, ToyCondition] = toyBoxLens andThen conditionLens

    val toyBox: ToyBox = lens.set(newToyBox, Used)

    println(toyBox)

    val students = Map("Mark" -> 100, "Jonathan" -> 350, "Bob" -> 65)

    val filteredStudents = students + ("Mark" -> (students("Mark") - 50))

    println(filteredStudents)

    import scalaz._
    import Scalaz._

    println(students |+| Map("Mark" -> -50))

    var nodes = Map.empty[Int, List[String]]

    nodes += (3 -> ("3" :: ~(nodes get 3)))
    nodes += (3 -> ("3" :: ~(nodes get 3)))
    nodes += (3 -> ("3" :: ~(nodes get 3)))

    println(nodes)

    var newNodes = Map.empty[Int, List[String]]

    println(newNodes |+| Map(3 -> List("3")))


  }

}
