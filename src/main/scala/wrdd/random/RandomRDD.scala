package wrdd.random

import org.apache.spark._
import org.apache.spark.rdd._

class RandomRDD(_sc: SparkContext, maxSize: Int = 100, numPartitions: Int = 2) extends RDD[Int](_sc, Nil) {

  override def compute(split: Partition, context: TaskContext): Iterator[Int] = ???

  override protected def getPartitions: Array[Partition] =  {
    val array = new Array[Partition](numPartitions)
    for (i <- 0 until numPartitions) {
      array(i) = new RandomPartition(i)
    }
    array
  }
}

class RandomPartition(val index: Int) extends Partition