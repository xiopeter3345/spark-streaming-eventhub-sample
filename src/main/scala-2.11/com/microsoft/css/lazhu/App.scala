package com.microsoft.css.lazhu

import org.apache.spark.eventhubs.rdd.{OffsetRange, HasOffsetRanges}
import org.apache.spark.{TaskContext, SparkConf}
import org.apache.spark.eventhubs.{EventPosition, EventHubsUtils, EventHubsConf, ConnectionStringBuilder}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by lazhu on 5/12/2018.
  */
object App {

  def main(args: Array[String]): Unit = {
    val connectionStr = "Endpoint=sb://lazhueventhub-ns1.servicebus.windows.net/;SharedAccessKeyName=lazhusap;SharedAccessKey=kz6/5vB8J4k2e9Lej0kfq1JIE2468g+DddFVBkxtbdc=;EntityPath=lazhueventhub"
    val conf = EventHubsConf(connectionStr)
      .setStartingPosition(EventPosition.fromEndOfStream)
      .setMaxRatePerPartition(10000)

    val sparkConf = new SparkConf()
    val ssc = new StreamingContext(sparkConf, Seconds(30))

    val stream = EventHubsUtils.createDirectStream(ssc, conf)

    try {
      stream.foreachRDD { rdd =>
        val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
        rdd.foreachPartition {
          iter =>
            val o: OffsetRange = offsetRanges(TaskContext.get.partitionId())
            println(s"${o.name} - ${o.partitionId} - ${o.fromSeqNo} - ${o.untilSeqNo}")
        }
      }
      ssc.start()
      ssc.awaitTermination()
    } catch {
      case ex: Exception =>
      ssc.stop()
    }
  }

}
