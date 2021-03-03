package com.github.mdh266

import scala.math.{exp, pow}
import scala.language.postfixOps
import scala.collection.JavaConversions._

case class PoissonDistribution(private var lambda : Double = 1.0) {

    // initialize uniform distribution
    val uniform = scala.util.Random

    // get n random samples of the distribution
    // Note: Need to convert to java List for py4j 
    // to convert to python properly
    def sample(n : Int) : java.util.List[Int]  = {
        if(n > 0) {
            seqAsJavaList(uniform(n).map(invCDF).toSeq)
        }
        else {
            throw new IllegalArgumentException("n > 0}")
        }
    }

    // lambda^{p} e^{-\lambda }/ p!
    def prob(p : Int) : Double = {
        if(p >= 0) {
            exp(-lambda) * pow(lambda, p) / (1 to p).product
        }
        else {
            throw new IllegalArgumentException("p >= 0}")
        }
    }

    // the prob(x)
    def cdf(x : Int) : Double = {
        if(x >= 0) {
            // create the list of array of integers from 0 to max_p
            val ps          = List.range(0,x+1)

            // find lambda^(ps[i]) / (ps[i] !) for each i
            val mapped_ps   = ps map(prob)

            getSum(mapped_ps)(x)
        }
        else {
            throw new IllegalArgumentException("x >= 0}")
        }
    }

    // Cant really get inverse of CDF analytically, following along lines of
    // https://math.stackexchange.com/questions/3693280/generate-a-poisson-random-variable-from-a-standard-uniform-random-variable
    def invCDF(x : Double) : Int = {

        val max_p      = 30

        // create the list of array of integers from 0 to max_p
        val ps          = List.range(0,max_p+1)

        // find lambda^(ps[i]) / (ps[i] !) for each i
        val mapped_ps   = ps map(prob)

        // curry the function to have the array fixed
        val curried_sum = getSum(mapped_ps) _

        // sum of the terms below
        val sums        = ps.map(curried_sum).toList

        // filter out values with issues of numerical under/overflow
        // this should occur for all values after certain index
        // then find the index where sums[i] <= s
        sums.filter(s  => (s <= 1.01 & s >= 0)).indexWhere(s => x <= s)
    }

    def getLambda() : Double = {
      lambda
    }

    def setLambda(l : Double) : Unit = {
        this.lambda = l
    }

    // get a array of uniform distributed doubles
    protected def uniform(n : Int) : List[Double] = {
      (for(i <- 0 until n) yield uniform.nextDouble ).toList
    }

    // finds the sum, exp(-lambda) * sum_{i=0}^{max_p} vals[i]
    protected def getSum(vals : List[Double])(max_p : Int) : Double = {
         vals.slice(0, max_p+1).reduce(_ + _)
    }
}