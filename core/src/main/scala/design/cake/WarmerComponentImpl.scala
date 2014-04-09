package design.cake

trait OnOffDeviceComponent {
  val onOff: OnOffDevice
  trait OnOffDevice {
    def on: String
    def off: String
  }
}
trait SensorDeviceComponent {
  val sensor: SensorDevice
  trait SensorDevice {
    def isCoffeePresent: Boolean
  }
}

// =======================
// service implementations
trait OnOffDeviceComponentImpl extends OnOffDeviceComponent {
  class Heater extends OnOffDevice {
    def on = "heater.on"
    def off = "heater.off"
  }
}
trait SensorDeviceComponentImpl extends SensorDeviceComponent {
  class PotSensor(isPresent: Boolean = true) extends SensorDevice {
    def isCoffeePresent = isPresent
  }
}
// =======================
// service declaring two dependencies that it wants injected
trait WarmerComponentImpl {
  this: SensorDeviceComponent with OnOffDeviceComponent =>
  class Warmer {
    def trigger: String = {
      if (sensor.isCoffeePresent) onOff.on
      else onOff.off
    }
  }
}
