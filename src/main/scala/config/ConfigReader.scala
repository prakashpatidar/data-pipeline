package config

import com.google.gson.Gson
import org.apache.logging.log4j.LogManager

import scala.io.Source
object ConfigReader {
  private val logger= LogManager.getLogger(ConfigReader.getClass)
  def read(configFileName:String):ProcessingConfig={
    logger.debug(s"reading config file:$configFileName")
    val gson = new Gson()
    val content=scala.io.Source.fromResource(configFileName).mkString
    logger.info(s"file:$configFileName, content:$content")
    gson.fromJson(content,classOf[ProcessingConfig])
  }
}
