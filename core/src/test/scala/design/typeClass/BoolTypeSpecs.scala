package design.typeClass

import org.scalatest.{ShouldMatchers, WordSpec}
import shapeless.test.illTyped

sealed trait BoolVal {
  def not:BoolVal$
  def or(that:BoolVal$):BoolVal$
  def and(that:BoolVal$) = (this.not or that.not).not
  def imp(that:BoolVal$) = this.not or that
}



sealed trait BoolType {
  type Not <: BoolType
  type Or[That <: BoolType] <: BoolType
}
sealed trait TrueType extends BoolType {
  override type Not = FalseType
  override type Or[That <: BoolType] = TrueType
}
sealed trait FalseType extends BoolType {
  override type Not = TrueType
  override type Or[That <: BoolType] = That
}

object BoolTypeSpecs {
  implicitly[TrueType#Not =:= FalseType]
  implicitly[FalseType#Not =:= TrueType]
  illTyped("implicitly[TrueType#Not =:= TrueType]")
  illTyped("implicitly[FalseType#Not =:= FalseType]")
  implicitly[TrueType#Or[TrueType] =:= TrueType]
  implicitly[TrueType#Or[FalseType] =:= TrueType]
  implicitly[FalseType#Or[TrueType] =:= TrueType]
  implicitly[FalseType#Or[FalseType] =:= FalseType]
}

//class BoolValSpecs extends WordSpec with ShouldMatchers {
//
//  case object TrueVal extends BoolVal {
//    override val not = FalseVal
//    override def or(that:BoolVal) = TrueVal
//  }
//
//  case object FalseVal extends BoolVal {
//    override val not = TrueVal
//    override def or(that:BoolVal) = that
//  }
//
//  "BoolVal.and" should {
//    "satisfy the expected truth table" in {
//        (TrueVal and TrueVal) should equal (TrueVal)
//        (TrueVal and FalseVal) should equal (FalseVal)
//        (FalseVal and TrueVal) should equal (FalseVal)
//        (FalseVal and FalseVal) should equal (FalseVal)
//     }
//  }
//  "BoolVal.imp" should {
//    "satisfy the expected truth table" in {
//      (TrueVal imp TrueVal) should equal(TrueVal)
//      (TrueVal imp FalseVal) should equal(FalseVal)
//      (FalseVal imp TrueVal) should equal(TrueVal)
//      (FalseVal imp FalseVal) should equal(TrueVal)
//    }
//  }
//}