import shapeless.=:!=

//trait AC
//
//class B(implicit imp: Int) extends AC { }
//
//object C extends B()(5){}
//
//implicit val imp: Int = 3
//
//class ExtendC extends B

trait Foo {
  protected val fish: String
}

trait Bar extends Foo {
  override protected val fish = "catfish"
}

def doStuff[T <: Foo](x: T)(implicit ev: T =:= Foo) = x

doStuff(new Bar{})
