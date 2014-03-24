package design.implicits.scope

object Foo {

  implicit object DummyFoo extends Foo {
    override val valid = true
  }

  def isValid: Boolean = {
    val scope = implicitly[Foo]
    scope.valid
  }
}

trait Foo {

  def valid : Boolean
}
