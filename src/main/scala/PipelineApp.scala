import config.ConfigReader

object PipelineApp extends App {

  val processingConfig=ConfigReader.read("processing-pipeline.json")
  println(processingConfig)
}
