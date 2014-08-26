class Foo

class Result extends Foo

def doStuff(implicit x: Foo) = println()

implicit val foo = new Foo
implicit val foo3 = new Foo
implicit val result = new Result