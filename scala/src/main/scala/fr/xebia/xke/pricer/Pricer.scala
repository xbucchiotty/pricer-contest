import java.lang.Math.max

case class Pricer(
                   initialStockPrice: Double,
                   strike: Double,
                   upFactor: Double,
                   riskFreeRate: Double,
                   expiration: Int) {

  private def round(double: Double): Double = Math.rint(double * 100) / 100

  private def R = riskFreeRate

  private def u = upFactor

  private def K = strike

  private val d = 1 / u

  private val q = (R - d) / (u - d)

  def fairValue: Double = {
    loop(0, initialStockPrice)
  }

  private def loop(period: Int, S: Double): Double = {
    if (period == expiration) {
      max(0, S - K)
    } else {
      val Cu = loop(period + 1, S * u)
      val Cd = loop(period + 1, S * d)

      round(1 / R * (q * Cu + (1 - q) * Cd))
    }
  }

}