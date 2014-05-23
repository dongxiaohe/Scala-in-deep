package design.linearization

trait SimpleContainer {

  type A

  def value: A

}

trait OnlyNumbers {

  type A >: Number

}

trait OnlyString {

  type A = String

}


