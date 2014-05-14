package design.typeClass

import org.scalatest._

sealed trait BoolVal$ {
  def not: BoolVal$
  def or(that: BoolVal$): BoolVal$
  def and(that:BoolVal$) = (this.not or that.not).not
  def imp(that:BoolVal$) = this.not or that
}

case object TrueVal$$ extends BoolVal$ {
  override val not = FalseVal$$

  override def or(that: BoolVal$) = TrueVal$$
}

case object FalseVal$$ extends BoolVal$ {
  override val not = TrueVal$$

  override def or(that: BoolVal$) = that
}

class BoolValSpecs extends WordSpec with ShouldMatchers {

  "BoolVal.and" should {
    "satisfy the expected truth table" in {
      (TrueVal$$ and TrueVal$$) should equal(TrueVal$$)
      (TrueVal$$ and FalseVal$$) should equal(FalseVal$$)
      (FalseVal$$ and TrueVal$$) should equal(FalseVal$$)
      (FalseVal$$ and FalseVal$$) should equal(FalseVal$$)
    }
  }
}