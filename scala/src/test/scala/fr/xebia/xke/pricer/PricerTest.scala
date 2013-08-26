import org.scalatest.BeforeAndAfter
import org.scalatest.FeatureSpec
import org.scalatest.matchers.ShouldMatchers

class PricerTest extends FeatureSpec with ShouldMatchers with BeforeAndAfter {

  feature("EUROPEAN OPTION with generalWay") {

    scenario("S0 = 100\tStrike = 102\tu = 1.07\tt = 1\t| 2.76") {

      val price = Pricer(
        initialStockPrice = 100,
        strike = 102,
        upFactor = 1.07,
        riskFreeRate = 1.01,
        expiration = 1)
        .fairValue

      price should equal(2.76)
    }

    scenario("S0 = 100\tStrike = 108\tu = 1.07\tt = 1\t| 0.00") {

      val price = Pricer(
        initialStockPrice = 100,
        strike = 108,
        upFactor = 1.07,
        riskFreeRate = 1.01,
        expiration = 1)
        .fairValue

      price should equal(0d)
    }

    scenario("S0 = 100\tStrike = 93.48\tu = 1.07\tt = 1\t| 7.46") {

      val price = Pricer(
        initialStockPrice = 100,
        strike = 93.48,
        upFactor = 1.07,
        riskFreeRate = 1.01,
        expiration = 1)
        .fairValue

      price should equal(7.46)
    }

    scenario("S0 = 100\tStrike = 100\tu = 1.07\tt = 3\t| 6.58") {

      val price = Pricer(
        initialStockPrice = 100,
        strike = 100,
        upFactor = 1.07,
        riskFreeRate = 1.01,
        expiration = 3)
        .fairValue

      price should equal(6.58)
    }

    scenario("S0 = 100\tStrike = 100\tu = 1.07\tt = 5\t| 8.87") {

      val price = Pricer(
        initialStockPrice = 100,
        strike = 100,
        upFactor = 1.07,
        riskFreeRate = 1.01,
        expiration = 5)
        .fairValue

      price should equal(8.87)
    }
  }
}