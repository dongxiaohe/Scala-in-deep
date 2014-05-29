import scala.reflect.{classTag, ClassTag}
abstract class Test[T:ClassTag];
class Test_1[T:ClassTag] extends Test
class Test_3[T:ClassTag] extends Test[T]

def t[A] = (l:Seq[A]) => l tail
def r[A] = (r:Seq[A]) => r reverse

(Function.chain(List(r[Int], t[Int], r[Int])))(List(1,2,3,4))

def tr[A] = ((x: List[A]) => x.tail) compose ((x: List[A]) => x.reverse)


