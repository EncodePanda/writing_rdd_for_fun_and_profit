package wrdd.random

import org.apache.spark._
import org.apache.spark.rdd._

import scala.util.Random._

class RandomRDD(_sc: SparkContext, maxSize: Int = 100, numPartitions: Int = 2) extends RDD[Int](_sc, Nil) {

  override def compute(split: Partition, context: TaskContext): Iterator[Int] =
     (1 to nextInt(maxSize / numPartitions)).map(n => nextInt()).toList.toIterator

  override protected def getPartitions: Array[Partition] =  {
    val array = new Array[Partition](numPartitions)
    for (i <- 0 until numPartitions) {
      array(i) = new RandomPartition(i)
    }
    array
  }
}

class RandomPartition(val index: Int) extends Partition
