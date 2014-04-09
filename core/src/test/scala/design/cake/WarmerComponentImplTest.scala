package design.cake

import org.scalatest.FunSuite

class WarmerComponentImplTest extends FunSuite {

  test("cake pattern composability") {

    object ComponentRegistryWithHeater extends OnOffDeviceComponentImpl with SensorDeviceComponentImpl with WarmerComponentImpl {
        val onOff = new Heater
        val sensor = new PotSensor
        val warmer = new Warmer
    }

    val warmerWithHeater = ComponentRegistryWithHeater.warmer

    assert(warmerWithHeater.trigger === "heater.on")

    object ComponentRegistryWithoutHeater extends OnOffDeviceComponentImpl with SensorDeviceComponentImpl with WarmerComponentImpl {
      val onOff = new Heater
      val sensor = new PotSensor(false)
      val warmer = new Warmer
    }

    val warmerWithoutHeater = ComponentRegistryWithoutHeater.warmer

    assert(warmerWithoutHeater.trigger === "heater.off")

  }

}
