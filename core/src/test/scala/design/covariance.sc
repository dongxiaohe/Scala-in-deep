class Base
class ExtendedBase extends Base
class ExtendedExtendedBase extends ExtendedBase

class Thing[+A] {

  def doStuff(x: A) = {}
}
//def take[A](x: Thing[A]) = ???
def take(x: Thing[ExtendedBase]) = {}
//take[ExtendedExtendedBase](new Thing[ExtendedBase])
take(new Thing[ExtendedExtendedBase])