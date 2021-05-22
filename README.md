# Frequentist & Bayesian Statistics With Py4J & PyMC3
----------

In this post I want to go back to the basics of statistics, but with an advanced spin on things. By "advanced spin" I mean, both from in terms of mathematics and computational techniques. The topic will dive into is:

    Estimating a single parameter value from a distribution and then quantifying the uncertantity in the estimate.
    
In general I will take two approaches to quantitfying the uncertainity in the estimate, the first of which is [frequentist](https://en.wikipedia.org/wiki/Frequentist_inference) and second that is [Bayesian](https://en.wikipedia.org/wiki/Bayesian_statistics).  I should admit, I am seasoned using Bayesian methods and that's why I'll be sticking to a simple example of estimating the mean rate or $\lambda$ in a [Poisson distribution](https://en.wikipedia.org/wiki/Poisson_distribution#) from sampled data. I should note I was inspired by [Jake Vanderplas' post](http://jakevdp.github.io/blog/2014/03/11/frequentism-and-bayesianism-a-practical-intro/).

From the computational perspective, I wanted to do something different and decided to write the probability distribution for generating the data in [Scala](https://www.scala-lang.org/), but then use it with Python. Why did I do this? Well, I like Scala and enjoyed the challenge of writing a Poisson distribution using a functional approach. I also wanted to learn more about how to use [Py4J](https://www.py4j.org/) which can be used to work with functions and objects in the [JVM](https://en.wikipedia.org/wiki/Java_virtual_machine) from Python. [Apache Spark](https://spark.apache.org/) actually uses Py4J in PySpark to write Python wrappers for their Scala API. I've used both PySpark and Spark in Scala extensively in the past and doing this project gave me an opportunity to understand how PySpark works much better.

In this post I covered maximum likelyhood estimators (MLE) and Bayesian point estimators. The MLE was simple and and show how quanitify the uncertaintity in the estimate using confidence intervals from the [Fisher information](https://en.wikipedia.org/wiki/Fisher_information). I use [PyMC3](https://docs.pymc.io/) to calculate two Bayesian estimators and the [credible Interval](https://en.wikipedia.org/wiki/Credible_interval). One can also show that in the limit of large data Bayesian estimators and Maximum Likelyhood estimators converge to the same thing! This is called the [Bernstein-von Miss Theorem](
https://en.wikipedia.org/wiki/Bernstein%E2%80%93von_Mises_theorem).


## Starting the Poisson distribution server with Py4J
--------

You must start the Java Server to sample from Poisson Distrbution using Scala & Py4J first build the jar:

	mvn package

Then start the server:

	java -jar target/poisson-1.0-jar-with-dependencies.jar


## Libraries:
----------
1. [Apache Maven](https://maven.apache.org/)
2. [Scala](https://www.scala-lang.org/)
3. [Py4J](https://www.py4j.org/)
4. [Python 3](https://www.python.org/)
5. [PyMC3](https://docs.pymc.io/)
6. [Seaborn](https://seaborn.pydata.org/)
7. [ArivZ](https://arviz-devs.github.io/arviz/)




