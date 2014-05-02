package core.collection

object FoldLeftSpec {

   def convert(str : String) : String = {
     def first = (str: String) => str.toUpperCase

     def second = (str: String) => str.reverse

     def third = (str: String) => str + " Cool"

     List(first, second, third).foldLeft(str)((ele, op) => op(ele))
   }

}
