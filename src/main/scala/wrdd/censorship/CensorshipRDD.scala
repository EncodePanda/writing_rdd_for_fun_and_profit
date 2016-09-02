package wrdd.censorship

import org.apache.spark._
import org.apache.spark.rdd._

object CensorshipRDD {

  val heresy = "Hadoop"
  val mask = "******"

  implicit class StringRDDOps(rdd: RDD[String]) {
    def censor() = new CensorshipRDD(rdd)
  }
}

class CensorshipRDD(prev: RDD[String]) extends RDD[String](prev) {

  def collectLegal(): Array[String] = {
    val results = context.runJob(this, (it: Iterator[String]) => it.filter(!_.toLowerCase().contains(CensorshipRDD.mask)).toArray)
    Array.concat(results: _*)
  }

  override def compute(split: Partition, context: TaskContext): Iterator[String] =
    firstParent[String].compute(split, context).map(str => str.replace(CensorshipRDD.heresy, CensorshipRDD.mask))

  override protected def getPartitions: Array[Partition] =
    firstParent[String].partitions
}



