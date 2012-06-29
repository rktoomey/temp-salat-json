import java.io.{File, FileFilter, PrintWriter}
import scala.xml._

import se.fishtank.css.selectors._
import se.fishtank.css.selectors.Selectors._



object WECDataProcessing {
  var sert: List[SertCountry] = Nil
  var issues: List[IssueCountry] = Nil

  def main(args: Array[String]) {
    import WECImplicits._

    println()
    println("WEC Data Processing")
    
    /*
    //  proof of concept
    val exampleFile = new File("in/example.xml")
    val example = XML.loadFile(exampleFile)
    println(example)
    //val foo = Selectors.query("example thing", example)
    val foo = example $ "example thing"
    println(foo)
    */

    // find input files
    val inputFolder = new File("in")
    val xmlFiles = inputFolder.listFiles.toList.filter(_.getName.endsWith(".xml"))

    val sertFile = selectFile(xmlFiles, "sert", "Select a SERT file:", "SERT file found", "No SERT file found")
    val indexFile = selectFile(xmlFiles, "index", "Select an Index file:", "Index file found", "No Index file found")
    val issuesFile = selectFile(xmlFiles, "sert", "Select an Issues file:", "Issues file found", "No Issues file found")
    val erdFile = selectFile(xmlFiles, "erd", "Select an ERD file:", "ERD file found", "No ERD file found")
    

    // load sert data
    for (file <- sertFile) {
      val sertxml = XML.loadFile(file)
      val countries = (for (line <- sertxml $ "Wec_countryId") yield line attr "Wec_countryId").distinct

      sert = for (id <- countries) yield {
        val lines = (sertxml $ "Wec_countryId").filter{ _.attr("Wec_countryId") == id }
        val name = lines.head attr "Wec_Countryname"

        //println(name)

        val years = for (line <- lines) yield {
          val yearID = line attr "YearID"
          val year = line attr_i "Year"

          //val coal = SertCoal(2 ^ "GWh/yr")
          val data = SertData()
          SertYear(yearID, year, data)
        }
        SertCountry(id, name, years)
      }
    }


    //  OUTPUT PHASE
    outputData(selectData(), "all.json")
  }

  def selectFile(xmlFiles: List[File], nameFragment: String, selectMessage: String, autoMessage: String, emptyMessage: String): Option[File] = {
    val files = xmlFiles.filter(_.getName.toLowerCase.contains(nameFragment))

    if (files.isEmpty) {
      println(emptyMessage)
      None
    } else if (files.tail.isEmpty) {
      println(autoMessage+": "+files.head.getName)
      Some(files.head) 
    } else {
      val numberedFiles = (1 to files.length).toList.zip(files).toMap

      println(selectMessage)
      for ((number, file) <- numberedFiles) 
        println(" "+number+": "+file.getName)
      print("> ")
      val n = Console.readLine.toInt
      numberedFiles.get(n)
    }
  }

  def selectData(): JSONData = {
    val countryData: Array[JSONCountry] = sert.map { country =>
      /* val years: List[CountryYear] = Nil  country.years.map { year =>
        JSONYear(year.id, year.year)
      } */
      JSONCountry(country.id, country.name)
    } //toArray

    JSONData(countryData)
  }

  def outputData(data: JSONData, filename: String) {
    println(data)
    /*
    val file = new File("out/"+filename)
    println("Output file: "+file)
    val json = data.toJSON
    println(json)
    val p = new PrintWriter(file)
    try { p.print(json) } finally { p.close() }
    */
  }
}

