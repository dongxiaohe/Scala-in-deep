package design

case class Planet(val name: String)
object PimpLibrary {


  object SolarSystem {
    val Mercury = new Planet("Mercury")
    val Venus = new Planet("Venus")
    val Earth = new Planet("Earth")
    val Mars = new Planet("Mars")
    val Jupiter = new Planet("Jupiter")
    val Saturn = new Planet("Saturn")
    val Uranus = new Planet("Uranus")
    val Neptune = new Planet("Neptune")
    val Pluto = new Planet("Pluto")
  }

  object Pimper {
//    implicit def pimpPlanet(planet: Planet) = {
//      new {
//        var distanceFromSun: Int = 0
//      }
//    }
//    import SolarSystem._
//
//    implicit def pimpPlanet(planet: Planet) = {
//      new {
//        var distanceFromSun: Int = planet match {
//          case Planet("Earth") => 1
//          case Planet("Jupiter") => 5
//        }
//      }
//    }
//
//
//    println("whatever")
//    Jupiter.distanceFromSun = 5 // AU
  }
  implicit def pimpPlanet(planet: Planet) = {
    new {

      val distanceFromSun: Int = planet match {
        case Planet("Earth") => 1
        case Planet("Jupiter") => 5
      }
    }
  }

  def main(args: Array[String]) {
    import SolarSystem._
    import Pimper._


      println(Jupiter.distanceFromSun)





    }

}
