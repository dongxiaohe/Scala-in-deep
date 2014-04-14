package akka.spike

import au.gov.cer.registry.testinfrastructure.ModelBuilderFactory._
import au.gov.cer.registry.testinfrastructure._
import au.gov.cer.registry.certmgmt.service.StcContext
import au.gov.cer.registry.testinfrastructure.CommandBuilders.offerStcsToClearingHouseCommand
import au.gov.cer.registry.account.domain.Account
import au.gov.cer.registry.security.domain.Role._
import au.gov.cer.registry.common.query.QueryBuilderFactory._

class ClearingHouseStatusServiceConcurrencySpec
  extends BaseServiceSpec with ConcurrencyContext with AuthenticationContext with StcContext {

  "Spike servce" should {
    "run command in parallel" in {

      given( clearingHouse(0))

      val accountOne = given( account)
      val allCertificates = given( aStcRange(tag = "offering to clearing house", account = accountOne) map (_.getSize))
      given( logged( account = accountOne))

      whenRunInParallel(offerStcsToClearingHouseCommand(
        numberOfCertificates = allCertificates,
        query = myCertificateRangesSearchQuery().withTag("offering to clearing house").build()), 10)

      3 mustEqual 3
    }
  }

  def logged(account: Account) = loggedInUserForAccountWithRoles(
    SELL_TO_STC_CLEARING_HOUSE, VIEW_MY_CERTIFICATE_ACTIVITY_LOG)(account)
}


