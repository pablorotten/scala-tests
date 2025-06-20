import FilesTest.writeStringToFile
import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}
import org.apache.poi.ss.usermodel._

import java.io.{File, FileInputStream}

object ExcelPOITest extends App {
  println("📊📊📊 ExcelPOITest 📊📊📊")

  val excelFile = new File("/Users/pro/Pablo-DEV/Scala-tests/excelFile.xlsx")
  val excelWorkbook = new XSSFWorkbook(new FileInputStream(excelFile))
  val sheet: XSSFSheet = excelWorkbook.getSheet("Sheet1")
  val row1 = sheet.getRow(1)

  val normalCell = row1.getCell(0)
  val cellWithFormat = row1.getCell(1)
  val cellWithComment = row1.getCell(2)
  val cellWithLeft = row1.getCell(3)
  val cellWithHyperlink = row1.getCell(4)

  val formatter = new DataFormatter()
  val formattedValue = formatter.formatCellValue(cellWithFormat)

  println(s"📝cellWithFormat value: ${cellWithFormat.toString}")
  println(s"📝cellWithFormat formattedValue: ${formattedValue}")
  println(s"📝cellWithFormat style format: ${cellWithFormat.getCellStyle.getDataFormatString}")

  println(s"💬 cellWithComment value: ${cellWithComment.toString}")
  println(s"💬 cellWithComment comment: ${cellWithComment.getCellComment.getString}")

  println(s"⬅️ cellWithLeft value: ${cellWithLeft.toString}")

  println(s"🔗 cellWithHyperlink value: ${cellWithHyperlink.toString}")
  println(s"🔗 cellWithHyperlink link: ${cellWithHyperlink.getHyperlink.getAddress}")

}
