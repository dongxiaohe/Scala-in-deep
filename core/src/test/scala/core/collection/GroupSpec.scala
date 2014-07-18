package core.collection

import org.scalatest.FunSuite

class GroupSpec extends FunSuite {

  test("more than one groupBy") {
    case class Data(date: String, uid: String, site: String, success: Int)

    val sampleData = List(
      Data("2014-07-30","userA","google",1),
      Data("2014-07-30","userA","google",1),
      Data("2014-07-30","userB","google",1),
      Data("2014-07-30","userC","yahoo",1),
      Data("2014-07-13","userD","facebook",3)
    )

    val result = sampleData.groupBy(_.date).map
    {case (date, datelist) => (date, datelist.groupBy(_.site).map
    {case (site, sitelist) => (site, sitelist.groupBy(_.uid).size)})}

    println(result)
    println(sampleData.groupBy(_.date))


  }

}
