package com.meritamerica.assignment4;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		System.out.println("Hello Merit America!");
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		MeritBank.writeToFile("BankOutput.txt");
	}
}