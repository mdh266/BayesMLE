package com.github.mdh266

case class PoissonEntryPoint() {

	def Poisson(lambda : Double) : PoissonDistribution = {
		new PoissonDistribution(lambda)
	}

}