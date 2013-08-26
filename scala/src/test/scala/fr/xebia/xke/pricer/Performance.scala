import concurrent.duration._
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{FunSuite, BeforeAndAfter, OneInstancePerTest}
import scala.concurrent.{Future, Await}

class Performance extends FunSuite with ShouldMatchers with BeforeAndAfter with OneInstancePerTest {

  import scala.concurrent.ExecutionContext.Implicits.global

  test("Performance") {
    val computations: Future[Seq[Double]] = Future {
      for (i <- 1 to 10)
      yield {
        Pricer(
          initialStockPrice = 100,
          strike = 100,
          upFactor = 1.07,
          riskFreeRate = 1.01,
          expiration = 20).fairValue
      }
    }

    Await.result(computations, 5 seconds) should not(be('empty))

  }
}
