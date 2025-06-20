import java.text.DecimalFormat
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

object ParsingDecimals extends App {
  val toFormat = 123456789.123
  val toFormat2 = "123456789.123"
  val pattern = "###,###.####"

  val decimalFormat = new DecimalFormat()

  decimalFormat.applyPattern(pattern)

  println(decimalFormat.format(toFormat))
  println(decimalFormat.parse(toFormat2))





//  val pattern = "###,###.####"
//  val format = new DecimalFormat(pattern)
//  format.applyPattern(pattern)
//  val test = "122323233.4"
//  println(test)
//  println(format.format(test))
//  println(test.format("###,###.####"))
}
