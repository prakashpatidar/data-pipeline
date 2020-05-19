package config

import com.google.gson.Gson
import config.Operation.Operation

case class ProcessingConfig(rootProcessingUnit: ProcessingUnit)
case class ProcessingUnit(processingUnits: Array[LeafProcessingUnit],operationInfo: OperationInfo)
case class LeafProcessingUnit(sources: Array[Source],operationInfo: OperationInfo) extends BaseProcessingUnit(sources,operationInfo)
class BaseProcessingUnit(sources: Array[Source],operationInfo: OperationInfo)
case class OperationInfo(operation: String, operationGrammar: String)
object Operation extends Enumeration {
  type Operation = Value
  val Filter: Value = Value("Filter")
  val Join: Value = Value("JOIN")
}
object JsonProducer extends App {
  val leafProcessingUnit1 = LeafProcessingUnit(Array(Source(1, "d1", "format")),OperationInfo("Filter","f1"))
  val leafProcessingUnit2 = LeafProcessingUnit(Array(Source(2, "d2", "format")),OperationInfo("Filter","f2"))
  val processingUnit = ProcessingUnit(Array(leafProcessingUnit1, leafProcessingUnit2),OperationInfo("Join","joinsql"))
  val processingConfig=ProcessingConfig(processingUnit)
  val gson = new Gson()
  val json =gson.toJson(processingConfig)
  println(json)
}
