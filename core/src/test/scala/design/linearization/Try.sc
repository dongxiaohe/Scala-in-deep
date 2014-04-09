class Dummy {
  def getName = "123"
}

trait X { val x : Dummy }
trait Y {self : X => ; val y = x.getName}
//new X with Y { val x = new Dummy}
new Y with X { val x = new Dummy}