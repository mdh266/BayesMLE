package com.github.mdh266
// import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

case class Lister() {

	def list_me() : java.util.List[Int] = {
		seqAsJavaList((for(i <- 0 until 3) yield i).toSeq)
	}
}