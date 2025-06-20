import io.circe.Encoder
import io.circe.generic.semiauto.deriveEncoder

import java.net.URI
import java.text.SimpleDateFormat
import io.circe.syntax._

object CaseClassToJson extends App {

  val study1 = IrtConnectionsIO.apply(Some(""), -1, "validTrialCode")
  val study2 = IrtConnectionsIO.apply(Some(""), -1, "validTrialCodeWithTrueDecision")
  val study3 = IrtConnectionsIO.apply(Some(""), -1, "invalidTrialCode")

  val jsonList = List(study1, study2, study3).asJson

  println(jsonList)

}

case class IrtConnectionsIO(
  instanceBaseURL: Option[String] = None,
  trialId: Int = -1,
  trialName: String = ""
)

object IrtConnectionsIO {
  implicit val encoder: Encoder[IrtConnectionsIO] = deriveEncoder[IrtConnectionsIO]

  val dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
  private def getInstanceHost(url: String) = Option(new URI(url).getHost).getOrElse(url)

  private def generateLink(baseUrl: String, key: String, id: Int) = s"${baseUrl}app/en/data/($key:$id:t)/(ds:$key)"

  def apply(
    instanceBaseURL: Option[String],
    trialId: Int,
    trialName: String
  ): IrtConnectionsIO = new IrtConnectionsIO(
    instanceBaseURL.map(getInstanceHost),
    trialId,
    trialName
  )

}
