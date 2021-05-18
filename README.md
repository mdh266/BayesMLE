# Frequentist & Bayesian Statistics With Py4J & PyMC3
----------

In this post I want to go back to the basics of statistics, but with an advanced spin on things. By "advanced spin" I mean, both from in terms of mathematics and computational techniques. The topic will dive into is:

Estimating a single parameter value from a distribution and then quantifying the uncertantity in the estimate.
In general I will take two approaches to quantitfying the uncertainity in the estimate, the first of which is frequentist and second that is Bayesian. I should admit, I am seasoned using Bayesian methods and that's why I'll be sticking to a simple example of estimating the mean rate or  𝜆  in a Poisson distribution from sampled data.

From the computational perspective, I wanted to do something different and decided to write the probability distribution for generating the data in Scala, but then use it with Python. Why did I do this? Well, I like Scala and enjoyed the challenge of writing a Poisson distribution using a functional approach. I also wanted to learn more about how to use Py4J which can be used to work with functions and objects in the JVM from Python. Apache Spark actually uses Py4J in PySpark to write Python wrappers for their Scala API. I've used both PySpark and Spark in Scala extensively in the past and doing this project gave me an opportunity to understand how PySpark works much better.

## Starting the Poisson distribution server with Py4J
--------

You must start the Java Server to sample from Poisson Distrbution using Scala & Py4J first build the jar:

	mvn package

Then start the server:

	java -jar target/poisson-1.0-jar-with-dependencies.jar


## Dependencies:
----------
1. [Apache Maven](https://maven.apache.org/)
2. [Scala](https://www.scala-lang.org/)
3. [Py4J](https://www.py4j.org/)
4. [Python 3](https://www.python.org/)
5. [PyMC3](https://docs.pymc.io/)
6. [Seaborn](https://seaborn.pydata.org/)




