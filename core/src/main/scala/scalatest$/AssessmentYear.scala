package scalatest$


case class AssessmentYear(certificateType: CertificateType, year: Int) {
  def getYearRange: Seq[Int] = certificateType match {
    case STC => 2011 to year
    case LGC => 2001 to year

  }
}


trait CertificateType

case object STC extends CertificateType
case object LGC extends CertificateType
