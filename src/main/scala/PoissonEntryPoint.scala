package com.github.mdh266

case class PoissonEntryPoint() {

	def Poisson(lambda : Double) : PoissonDistribution = {
		var p = new PoissonDistribution()
		p.setLambda(lambda)
		p
	}
	
}