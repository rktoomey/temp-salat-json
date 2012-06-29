package app

import com.novus.salat.json.{StringObjectIdStrategy, StringDateStrategy, JSONConfig}
import com.novus.salat.{TypeHintFrequency, StringTypeHintStrategy, Context}
import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat

package object context {
  implicit val ctx = new Context {
    val name = "json-test-context"
    override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary,
      typeHint = "_t")
    // TODO: customise your JSON output here
//    override val jsonConfig = JSONConfig(
//      dateStrategy = StringDateStrategy(dateFormatter = ISODateTimeFormat.dateTime.withZone(DateTimeZone.forID("US/Eastern"))),
//      objectIdStrategy = StringObjectIdStrategy)
  }
}
