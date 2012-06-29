import java.io.{File, FileFilter, PrintWriter}
import scala.xml._

import se.fishtank.css.selectors._
import se.fishtank.css.selectors.Selectors._



object JSONError {
  def main(args: Array[String]) {
    val data = JSONData(
      List(
        JSONCountry("9c5bae60-4d6f-e111-afed-00155d6f0a00","Afghanistan"),
        JSONCountry("6839e350-987a-df11-adcb-a4badb122fb5","Albania"),
        JSONCountry("6417d9e8-977a-df11-adcb-a4badb122fb5","Algeria"), 
        JSONCountry("c770d76a-da78-e111-b4c3-00155d6f0a00","Andorra"), 
        JSONCountry("6939e350-987a-df11-adcb-a4badb122fb5","Angola"), 
        JSONCountry("c2692d50-c5be-e111-9b52-00155d6f0a00","Anguilla"), 
        JSONCountry("8aa32d71-da78-e111-b4c3-00155d6f0a00","Antarctica"), 
        JSONCountry("cb2e8557-c5be-e111-9b52-00155d6f0a00","Antigua and Barbuda"), 
        JSONCountry("b717d9e8-977a-df11-adcb-a4badb122fb5","Argentina"), 
        JSONCountry("2ee38920-ccf3-df11-afd5-a4badb122fb5","Armenia"), 
        JSONCountry("ce2e8557-c5be-e111-9b52-00155d6f0a00","Aruba"), 
        JSONCountry("6a39e350-987a-df11-adcb-a4badb122fb5","Australia"), 
        JSONCountry("9317d9e8-977a-df11-adcb-a4badb122fb5","Austria"), 
        JSONCountry("6b39e350-987a-df11-adcb-a4badb122fb5","Azerbaijan"), 
        JSONCountry("4efa73a7-da78-e111-b4c3-00155d6f0a00","Azores")
        )
      )
    outputData(data, "all.json")
  }

  def outputData(data: JSONData, filename: String) {
    println(data)

    val json = data.toJSON
    println(json)

    val file = new File("out/"+filename)
    println("Output file: "+file)
    val p = new PrintWriter(file)
    try { p.print(json) } finally { p.close() }
  }
}

