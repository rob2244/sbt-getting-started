object NetWorthMultiCurrency extends App {
  def calculate(assets: Double, liabilities: Double) = assets - liabilities

  override def main(args: Array[String]): Unit = {
    val assets = args(0)
    val liabilities = args(1)

    val assetsInEuros = assets.split(",").map(Currency(_))
    val liabilitiesInEuros = liabilities.split(",").map(Currency(_))

    val totalAssetsInEuros = assetsInEuros.map(_.valueInEuros).sum
    val totalLiabilitiesInEuros = liabilitiesInEuros.map(_.valueInEuros).sum

    println(s"Your net worth is ${calculate(totalAssetsInEuros, totalLiabilitiesInEuros)}")
  }
}

object Currency {
  val currencyConverter = Forex.getExchangeRates

  def apply(value: String) = {
    val Array(amountString: String, currencyCode: String) = value.split("\\s")
    val amount = amountString toLong

    if (currencyCode != "EUR") {
      val multiplier = 1 / currencyConverter(currencyCode)
      println(s"$currencyCode -> EUR : $multiplier")
      new Currency(amount, currencyCode, amount * multiplier)
    }

    new Currency(amount, currencyCode, amount)
  }
}

case class Currency(amount: Long, code: String, valueInEuros: Double)