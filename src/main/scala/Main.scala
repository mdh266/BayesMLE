package com.github.mdh266

import py4j.GatewayServer

object Main {
	def main(args: Array[String]) = {
		val server = new GatewayServer(new PoissonEntryPoint())
		server.start()
		System.out.println("Gateway Server Started")
	}
}