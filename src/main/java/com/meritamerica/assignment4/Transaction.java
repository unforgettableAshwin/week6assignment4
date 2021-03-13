package com.meritamerica.assignment4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction
{
	private byte transactionCode;

	private java.util.Date dateOfTrx;

	private BankAccount targetAccount;

	private BankAccount sourceAccount;

	private double amount;

	public byte getTransactionCode()
	{
		return transactionCode;
	}

	public void setTransactionCode(
			byte transactionCode
	)
	{
		this.transactionCode = transactionCode;
	}

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

	public java.util.Date getTransactionDate()
	{
		return dateOfTrx;
	}

	public void setTransactionDate(
			java.util.Date date
	)
	{
		this.dateOfTrx = date;
	}

	public String writeToString()
	{
		return null;
	}

	public static Transaction readFromString(
			String transactionDataString
	)
	{
		Transaction t;

		String[] s = transactionDataString.split( "," );
		//t.transactionCode = Byte.parseByte( s[ 0 ] );
		long targetAccount = Long.parseLong( s[ 1 ] );
		double amount = Double.parseDouble( s[ 2 ] );
		DateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
		Date date = df.parse( s[ 3 ] );
		if( t.transactionCode < 0 )
		{
			if( amount < 0 )
			{
				//WithdrawTransaction wt = new WithdrawTransaction( , amount);
			}
			else
			{
				//DepositTransaction dt = new DepositTransaction();
			}
		}
		else
		{

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
