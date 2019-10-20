import org.scalatest.{FlatSpec, Matchers}

class NetWorthSpec extends FlatSpec with Matchers {
  "A Net worth Calculator" should "return 500" in {
    NetWorth.calculateAssets(1000, 500) should be (500)
  }

  "A Net worth Calculator" should "return 5000" in {
    NetWorth.calculateAssets(10000, 5000) should be (5000)
  }
}
