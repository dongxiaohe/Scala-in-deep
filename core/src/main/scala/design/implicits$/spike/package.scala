package design.implicits$

package object spike {

  implicit def takeTime(x: String): Talketive = new Talketive

}
