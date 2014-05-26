package design.typeClass.typeSafe

class ExistentialType {

}

class A

class C extends A

class Bar[_ <: A] {

}

class Foo[B <: A]
