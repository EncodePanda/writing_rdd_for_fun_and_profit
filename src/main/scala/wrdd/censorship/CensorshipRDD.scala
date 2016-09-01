package wrdd.censorship

import org.apache.spark._
import org.apache.spark.rdd._

class CensorshipRDD(prev: RDD[String]) extends RDD[String](prev) {

  override def compute(split: Partition, context: TaskContext): Iterator[String] = ???

  override protected def getPartitions: Array[Partition] = ???
}



