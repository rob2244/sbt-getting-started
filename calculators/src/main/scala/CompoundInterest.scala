object CompoundInterest extends App {
  def calculate(m: Double, r: Double, t: Int, n: Int = 1) =
    m * (math.pow(1 + r / n, n * t) - 1) * (n / r)

  override def main(args: Array[String]): Unit = {
    val principle = args(0).toDouble
    val rate = args(1).toDouble
    val numYears = args(2).toInt

    println(f"Your investment of $principle will be worth ${calculate(principle, rate / 100, numYears)}%f in $numYears years")
  }
}
