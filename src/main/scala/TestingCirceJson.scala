import io.circe._
import io.circe.parser._
import io.circe.syntax._
import io.circe.Decoder
import io.circe.generic.auto.{exportDecoder, exportEncoder}
import io.circe.generic.semiauto._
import io.circe.literal.JsonStringContext


object TestingCirceJson extends App {

  //§1 Let's do the same as in supply
  private case class SuiteFrontConfig(crossSellingURLs: Map[String, String])

  private case class NewConfig(enableGenericEndpoint: String = "")

  val crossSellingURLs = Map("production" -> "https://lifesciences.n-side.com/production-app", "supply" -> "https://lifesciences.n-side.com/supply-app", "dashboards" -> "https://lifesciences.n-side.com/supply-app")

  val suiteConf = SuiteFrontConfig(crossSellingURLs).asJson.noSpaces
  val parsedSuiteConf = parse(suiteConf).toOption.get
  val newConf = NewConfig(enableGenericEndpoint = "false").asJson
  val hardcoded = """{"crossSellingURLs":{"production":"https://lifesciences.n-side.com/production-app","supply":"https://lifesciences.n-side.com/supply-app","dashboards":"https://lifesciences.n-side.com/supply-app"},"enableGenericEndpoint":false}"""
  val mergeWithNewJson = newConf.deepMerge(Json.fromFields(List(("a", Json.fromInt(1)))))
  val mergeWithNewJson2 = newConf.deepMerge(Json.fromFields(List(("a", Json.fromInt(1)))))
  val mergeWithEmpty = newConf.deepMerge(Json.fromFields(List()))

  println(hardcoded.asJson)
  val mergedConf1 = newConf.deepMerge(parsedSuiteConf).noSpaces

  println(newConf.noSpaces)
  println(parsedSuiteConf.noSpaces)
  println(mergedConf1)
  println(hardcoded)
  println(mergeWithEmpty.noSpaces)
  println(Json.fromFields(List()))
  println(Json.fromFields(List()).noSpaces)
  println(NewConfig.asJson.deepMerge(Json.fromFields(List(("a", Json.fromInt(1))))))
}