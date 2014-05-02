package design.implicits$.constraint

trait Animal[SuitableFood <: Food] {

  def fish(implicit food: SuitableFood =:= Fish):String = "I got a fish"

  def fruit[T <: Fruit](x: T):String = "I got a fish"

}
