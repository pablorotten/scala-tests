import java.net.URI

object UrlAndHosts extends App {

  val urls = List(
    "https://csl-suite-clinical-trials.n-side.com/",
    "https://opko-suite-clinical-trials.n-side.com/",
    "https://ucb-suite-clinical-trials.n-side.com/",
    "https://suite-clinical-trials-uat-track4.n-side.com/",
    "https://suite-clinical-trials-uat-scale-master2.com/",
    "assdasd"
  )

  val domains = urls.map(url => new URI(url).getHost)
  domains.foreach(println)

  val badUrl = Option(new URI("asdasd").getHost)
  println(badUrl)

}
