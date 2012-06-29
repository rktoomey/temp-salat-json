
import scala.xml._

object WECImplicits {
  implicit def node2extra(node: Node) = new NodeExtra(node)
  class NodeExtra(node: Node) {
    def attr (attr: String) = (node \ ("@"+attr)).toString
    def attr_i (attr: String) = (node \ ("@"+attr)).toString.toInt
    def attr_f (attr: String) = (node \ ("@"+attr)).toString.toFloat
  }

  implicit def int2unit(number: Int) = new NumberUnit(number.toFloat)
  implicit def long2unit(number: Long) = new NumberUnit(number.toFloat)
  implicit def float2unit(number: Float) = new NumberUnit(number.toFloat)
  implicit def double2unit(number: Double) = new NumberUnit(number.toFloat)
  class NumberUnit(number: Float) {
    def ^ (unit: String) = new UnitNumber(number, unit)
  }
}