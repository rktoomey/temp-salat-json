import com.novus.salat._
import com.novus.salat.global._

/*
JSON model classes
*/

case class JSONData(
  countries: List[JSONCountry]
  ) {
  def toJSON = {
    println("\n\nIndividual countries")
    val cjson = for (c <- countries) grater[JSONCountry].toCompactJSON(c)

    println("\n\nAs a list")
    val cjlist = grater[JSONCountry].toCompactJSONArray(countries)
    //println(cjlist)

    println("\n\nThe whole thing")
    grater[JSONData].toJSON(this)
  }
}

case class JSONCountry(
  countryID: String,
  country: String
  )
