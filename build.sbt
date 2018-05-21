name := "spark-streaming"

version := "1.0"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  "com.microsoft.azure" % "azure-eventhubs-spark_2.11" % "2.2.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.2.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.2.0",
  "org.apache.spark" % "spark-sql_2.11" % "2.2.0",
  "com.microsoft.azure" % "azure-eventhubs" % "1.0.1",
  "org.apache.spark" % "spark-core_2.11" % "2.2.0"
)