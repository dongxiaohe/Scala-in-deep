trait Event

case class AnimalEvent() extends Event

case class BookEvent() extends Event

case class UnrelatedEvent() extends Event

type EventHandler = PartialFunction[Event, Unit]

val animalEventHandler: EventHandler = {
  case AnimalEvent() => println("processing animal event")
}

val bookEventHandler: EventHandler = {
  case BookEvent() => println("processing book event")
}

val defaultHandler: EventHandler = {
  case _ => println("nothing to process")
}

val handlerChain = animalEventHandler.orElse(bookEventHandler).orElse(defaultHandler)

handlerChain(AnimalEvent())
handlerChain(BookEvent())
handlerChain(UnrelatedEvent())