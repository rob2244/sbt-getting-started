import org.scalatest.{FlatSpec, Matchers}

class ForexSpec extends FlatSpec with Matchers {
  "The Forex api" should "fetch 32 currencies" in {
    val ex = Forex.getExchangeRates
    ex.size should be(32)
  }
}
