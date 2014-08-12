import io.Source
import xml.pull._
import xml._

// Make it "def", because the Source is stateful and may be exhausted after it is read
def xmlsrc: xml.Elem  = <Response>
  <Result att1="1" att2="2" att3="3" att4="4" att5="5"/>
  <Result att1="1" att2="2" att3="3" att4="4" att5="5"/>
  <Result att1="1" att2="2" att3="3" att4="4" att5="5"/>
  <Result att1="1" att2="2" att3="3" att4="4" att5="5"/>
</Response>

// Also as "def", because the result is an iterator that may be exhausted
//    def xmlEr=new XMLEventReader(xmlsrc)

//    xmlsrc.flatMap()

// flatMap keeps the "outer shape" of the type it operates, so we are still dealing with an iterator

def attrs = xmlsrc.flatMap{
  case e : EvElemStart => e.attrs.map(a => (a.key, a.value))
  case _ => Iterable.empty
}

// Now lets look what is inside:
attrs.foreach(println _)