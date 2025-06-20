import java.io.{File, FileOutputStream, OutputStreamWriter, PrintWriter}

object FilesTest extends App {

  def writeStringToFile(path: String, ENCODING: String = "UTF-8"): File = {
    val file = new File(path)
    Option(file.getParentFile).foreach { p =>
      if (!p.exists()) p.mkdirs()
    }
    if (!file.exists) file.createNewFile
    new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING))
    file
  }
}
