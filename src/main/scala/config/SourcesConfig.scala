package config
case class SourcesConfig(sources:Array[Source])
case class Source(id:Int, name:String, format:String, options:java.util.HashMap[String,String]=new java.util.HashMap())
