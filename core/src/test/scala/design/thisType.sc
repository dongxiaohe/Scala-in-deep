trait Foo {


  val doStuff: this.type = {
    this
  }

}

class Bar extends Foo

new Bar() doStuff
