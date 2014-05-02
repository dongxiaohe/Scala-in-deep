package design.linearization

object TraitAbstractValSpec {

  trait Foo {
    val name : String

    override val toString = name
  }

}
