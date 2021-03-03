package com.github.mdh266

case class PoissonEntryPoint() {
	
	var p = new PoissonDistribution()

	def Poisson(lambda : Double) : PoissonDistribution = {
		p.setLambda(lambda)
		p
	}

	
}