import io.circe._
import io.circe.parser._
import io.circe.generic.auto._

object PlayGround extends App {

  val json =
    "[{\"instanceBaseURL\":null,\"trialId\":4,\"trialName\":\"ns-000001 OLA\",\"trialLink\":null,\"connectionId\":null,\"connectionName\":null,\"importJobId\":null,\"importJobExecutionId\":null,\"importJobExecutionStartDate\":null,\"importJobStatus\":null,\"importJobErrorCount\":null,\"importJobLink\":null,\"extractId\":null,\"extractName\":null,\"extractUpdateDate\":null,\"extractErrorCount\":null,\"extractFatalCount\":null,\"extractLink\":null},{\"instanceBaseURL\":null,\"trialId\":5,\"trialName\":\"ns-000002 OLAA\",\"trialLink\":null,\"connectionId\":null,\"connectionName\":null,\"importJobId\":null,\"importJobExecutionId\":null,\"importJobExecutionStartDate\":null,\"importJobStatus\":null,\"importJobErrorCount\":null,\"importJobLink\":null,\"extractId\":null,\"extractName\":null,\"extractUpdateDate\":null,\"extractErrorCount\":null,\"extractFatalCount\":null,\"extractLink\":null},{\"instanceBaseURL\":null,\"trialId\":6,\"trialName\":\"ns-000003 OLAAAA\",\"trialLink\":null,\"connectionId\":null,\"connectionName\":null,\"importJobId\":null,\"importJobExecutionId\":null,\"importJobExecutionStartDate\":null,\"importJobStatus\":null,\"importJobErrorCount\":null,\"importJobLink\":null,\"extractId\":null,\"extractName\":null,\"extractUpdateDate\":null,\"extractErrorCount\":null,\"extractFatalCount\":null,\"extractLink\":null}]"

  val bad = decode[Seq[BadCaseClass]](json)
  val good = decode[Seq[GoodCaseClass]](json)

  println(bad)
  println(good)

}

case class BadCaseClass(
  instanceBaseURL: Boolean = false
)

case class GoodCaseClass(
  instanceBaseURL: Option[String] = None,
  trialId: Int = -1,
  trialName: String = "",
  trialLink: Option[String] = None,
  connectionId: Option[Int] = None,
  connectionName: Option[String] = None,
  importJobId: Option[Int] = None,
  importJobExecutionId: Option[Int] = None,
  importJobExecutionStartDate: Option[String] = None,
  importJobStatus: Option[Int] = None,
  importJobErrorCount: Option[Int] = None,
  importJobLink: Option[String] = None,
  extractId: Option[Int] = None,
  extractName: Option[String] = None,
  extractUpdateDate: Option[String] = None,
  extractErrorCount: Option[Int] = None,
  extractFatalCount: Option[Int] = None,
  extractLink: Option[String] = None
)
