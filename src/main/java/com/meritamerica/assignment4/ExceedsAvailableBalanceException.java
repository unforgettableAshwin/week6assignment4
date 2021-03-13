package com.meritamerica.assignment4;

public class ExceedsAvailableBalanceException extends Exception
{
	ExceedsAvailableBalanceException()
	{
		System.out.println( "ExceedsAvailableBalanceException" );
	}
	
	private static final long serialVersionUID = 1L;
}
