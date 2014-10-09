package scalatest$


case class AssessmentYear(certificateType: CertificateType, year: Int) {

  private val stcStartYear = 2011
  private val lgcStartYear = 2001

  def getYearRange: Seq[Int] = certificateType match {
    case LGC => lgcStartYear to year
    case STC => stcStartYear to year
  }

}


trait CertificateType

case object STC extends CertificateType
case object LGC extends CertificateType
