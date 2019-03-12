package uk.gov.hmrc.pdfgenerator.service

import com.typesafe.config.ConfigFactory
import org.scalatest.{MustMatchers, WordSpec}
import play.api.{Configuration, Environment}
import uk.gov.hmrc.pdfgenerator.resources._


class PdfGeneratorServiceSpec extends WordSpec with MustMatchers{

  val testConfig = new Configuration(ConfigFactory.load("test-application.conf"))
  val service = new PdfGeneratorService(testConfig, MockResourceHelper)

  "A PdfGeneratorService" should {
    "load the default production config values" in {
      assert(service.ADOBE_COLOR_PROFILE_FULL_PATH == service.PROD_ROOT + "AdobeRGB1998.icc")
      assert(service.PS_DEF_FILE_FULL_PATH.endsWith("PDFA_def.ps"))
      assert(!service.BASE_DIR_DEV_MODE)
      assert(service.GS_ALIAS.endsWith("/bin/gs-920-linux_x86_64"))
      assert(service.WK_TO_HTML_EXECUTABLE.endsWith("/bin/wkhtmltopdf"))

    }
  }


}
