package com.github.mdh266

import java.net.InetAddress
import py4j.GatewayServer

object Main {
	def main(args: Array[String]) = {
		System.setProperty("java.net.preferIPv4Stack", "true");
		val addr = InetAddress.getByName("0.0.0.0")
		val app = new PoissonEntryPoint()
		val builder = new GatewayServer.GatewayServerBuilder(app)
		builder.javaAddress(addr);
		val server = builder.build();
		server.start()
		println("Gateway Server Started")
	}
}