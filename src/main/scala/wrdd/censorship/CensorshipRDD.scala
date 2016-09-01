package wrdd.censorship

import org.apache.spark._
import org.apache.spark.rdd._

class CensorshipRDD extends RDD[String]() {

  override def compute(split: Partition, context: TaskContext): Iterator[String] = ???

  override protected def getPartitions: Array[Partition] = ???
}



