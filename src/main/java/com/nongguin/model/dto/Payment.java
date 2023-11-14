package com.nongguin.model.dto;

import java.util.Date;

public class Payment {
	private int paymentId;
	private int paymentAmount;
	private Date paymentDate;
	private int userId;
	private int matchId;
	
	public Payment() {
		
	}
	
	public Payment(int paymentId, int paymentAmount, Date paymentDate, int userId, int matchId) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.userId = userId;
		this.matchId = matchId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate
				+ ", userId=" + userId + ", matchId=" + matchId + "]";
	}
}
