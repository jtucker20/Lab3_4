package edu.mcdaniel.java2206.AndreBerry_lab3_4;

import edu.mcdaniel.java2206.AndreBerry_lab3_4.toyotas.ToyotaCamry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {



	@Test
	void contextLoads()
	{
		//We are testing to see if the spring boot application loads.
		// This will fail only if the spring boot
		// application fails to load. No need to add functionality here.
	}
	void polymorphicTest()
	{
		ToyotaCamry camry = new ToyotaCamry();

		Object obj = new Object();

		camry = (ToyotaCamry) obj; //Creates class cast exception

		obj = camry;

		int one = 1;

		double done = 1.0;

		one = (int) done;
	}


}
