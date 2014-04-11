trait AC

class B(implicit imp: Int) extends AC { }

object C extends B()(5){}

implicit val imp: Int = 3

class ExtendC extends B