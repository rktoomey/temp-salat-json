package model

import com.novus.salat._
import app.context._

/*
JSON model classes
*/

case class JSONData(
                     countries: List[JSONCountry]
                     ) {
  def toJSON = {
    println("\n\nIndividual countries")
//    val cjson = for (c <- countries) grater[JSONCountry].toCompactJSON(c)
    countries.foreach(c => println(grater[JSONCountry].toCompactJSON(c)))

    println("\n\nAs a list")
    println(grater[JSONCountry].toCompactJSONArray(countries))

    println("\n\nThe whole thing")
    println(grater[JSONData].toCompactJSON(this))

    grater[JSONData].toJSON(this)
  }
}

case class JSONCountry(
                        countryID: String,
                        country: String
                        )
