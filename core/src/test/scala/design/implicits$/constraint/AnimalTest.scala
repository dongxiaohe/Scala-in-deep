package design.implicits$.constraint

import org.scalatest.FunSuite

class AnimalTest extends FunSuite {

   test("Apple can not fish") {
     class People extends Animal[Fruit]

 //    new People().fish
   }

   test("Bear can fish") {
     class Bear extends Animal[Fish]

     assert(new Bear().fish === "I got a fish")

     trait OnOffDeviceComponent {
       val onOff: OnOffDevice
       trait OnOffDevice {
         def on(): Unit
         def off(): Unit
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
         def on() = println("heater.on")
         def off() = println("heater.off")
       }
     }
     trait SensorDeviceComponentImpl extends SensorDeviceComponent {
       class PotSensor extends SensorDevice {
         def isCoffeePresent = true
       }
     }
     // =======================
     // service declaring two dependencies that it wants injected
     trait WarmerComponentImpl {
       this: SensorDeviceComponent with OnOffDeviceComponent =>
       class Warmer {
         def trigger() = {
           if (sensor.isCoffeePresent) onOff.on()
           else onOff.off()
         }
       }
     }

     // =======================
     // instantiate the services in a module
     object ComponentRegistry extends
     OnOffDeviceComponentImpl with
     SensorDeviceComponentImpl with
     WarmerComponentImpl {

       val onOff = new Heater
       val sensor = new PotSensor
       val warmer = new Warmer
     }

     // =======================
     val warmer = ComponentRegistry.warmer
     warmer.trigger()
   }

 }
