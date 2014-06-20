trait Foo {

  def get(x: Int): Int

}

trait Simple extends Foo {

  override def get(x: Int): Int = x

}

trait Add15 extends Foo {

  abstract override def get(x: Int): Int = x + 15

}

trait Add30 extends Foo {

  abstract override def get(x: Int): Int = {

    super.get(x) + 30
  }

}

trait NoChange extends Foo {

  abstract override def get(x: Int): Int = 3

}

class Queue extends Simple with Add15 with Add30

new Queue get 0