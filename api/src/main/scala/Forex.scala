import scala.xml._

object Forex extends App {
  def getExchangeRates() = {
    val apiURL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"
    val resp = requests.get(apiURL)

    val xml = XML.loadString(resp.text)
    val codes = (xml \\ "@currency").map(_.text)
    val rates = (xml \\ "@rate").map(_.text.toDouble)
    val multipliers = (codes zip rates).toMap
    multipliers
  }

  println(getExchangeRates)
}
