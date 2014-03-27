package design.traitUsage

object TraitAbstractValSpec {

  trait Foo {
    val name : String

    override val toString = name
  }

}
