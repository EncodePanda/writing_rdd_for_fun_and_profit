package wrdd

import org.apache.spark._

object Main extends App {

  println("sandbox")
  val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Main"))

  

  sc.stop()

}
