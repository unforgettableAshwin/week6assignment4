package com.meritamerica.assignment4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction
{

	private static Date date;

	private static BankAccount targetAccount;

	private static BankAccount sourceAccount;

	private static double amount;
	
	private static Transaction t;
	
	

	public BankAccount getSourceAccount()
	{
		return sourceAccount;
	}

	public void setSourceAccount(
			BankAccount sourceAccount
	)
	{
		this.sourceAccount = sourceAccount;
	}

	public BankAccount getTargetAccount()
	{
		return targetAccount;
	}

	public void setTargetAccount(
			BankAccount targetAccount
	)
	{
		this.targetAccount = targetAccount;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(
			double amount
	)
	{
		this.amount = amount;
	}

	public Date getTransactionDate()
	{
		return date;
	}

	public void setTransactionDate(
			Date date
	)
	{
		this.date = date;
	}

	public String writeToString()
	{
		return null;
	}

	public static Transaction readFromString(
			String transactionDataString
	)
	{
		String[] s = transactionDataString.split( "," );
	
		long sourceAccountAccNum = Long.parseLong( s[ 0 ] );
		sourceAccount = MeritBank.getBankAccount(sourceAccountAccNum);
		
		long targetAccountAccNum = Long.parseLong( s[ 1 ] );
		targetAccount = MeritBank.getBankAccount(targetAccountAccNum);
		amount = Double.parseDouble( s[ 2 ] );
		
		try {
			DateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
			date = df.parse( s[ 3 ] );
		}
		catch( ParseException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if( sourceAccountAccNum < 0 )
		{
			//		-1,10,5000,01/01/2020
			if( amount < 0 )
			{
//				for (int i = 0; i < this.)
				WithdrawTransaction t = new WithdrawTransaction(targetAccount, amount);
				t.setTransactionDate(date);
			}
			else
			{
				DepositTransaction t = new DepositTransaction(targetAccount, amount);
				t.setTransactionDate(date);
			}
		}
		
		else if( sourceAccountAccNum > 0 )
		{
//			from 2, to 4,5000,01/05/2020
					
			TransferTransaction t = new TransferTransaction(sourceAccount, targetAccount, amount);
			t.setTransactionDate(date);
			
		}
		
		
		return t;
	}

	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;

	public boolean isProcessedByFraudTeam()
	{
		return false;
	}

	public void setProcessedByFraudTeam(
			boolean isProcessed
	)
	{
	}

	public String getRejectionReason()
	{
		return null;
	}

	public void setRejectionReason(
			String reason
	)
	{
	}

}
