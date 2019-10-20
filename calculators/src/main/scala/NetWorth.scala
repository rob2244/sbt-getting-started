object NetWorth extends App {
  def calculateAssets(assets: Long, liabilities: Long) = assets - liabilities

  val assets = args(0).toLong
  val liabilities = args(1).toLong
  println(s"Your net worth is ${calculateAssets(assets, liabilities)}")
}
