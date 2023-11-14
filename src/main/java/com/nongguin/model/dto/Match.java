package com.nongguin.model.dto;

import java.util.Date;

public class Match {
	private int matchId;
	private Date matchDate;
	private int matchApplicantCnt;
	private String matchLevel;
	private String matchGender;
	private int operationHourId;
	private int courtId;
	
	public Match() {
		
	}
	
	public Match(int matchId, Date matchDate, int matchApplicantCnt, String matchLevel, String matchGender,
			int operationHourId, int courtId) {
		super();
		this.matchId = matchId;
		this.matchDate = matchDate;
		this.matchApplicantCnt = matchApplicantCnt;
		this.matchLevel = matchLevel;
		this.matchGender = matchGender;
		this.operationHourId = operationHourId;
		this.courtId = courtId;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public int getMatchApplicantCnt() {
		return matchApplicantCnt;
	}

	public void setMatchApplicantCnt(int matchApplicantCnt) {
		this.matchApplicantCnt = matchApplicantCnt;
	}

	public String getMatchLevel() {
		return matchLevel;
	}

	public void setMatchLevel(String matchLevel) {
		this.matchLevel = matchLevel;
	}

	public String getMatchGender() {
		return matchGender;
	}

	public void setMatchGender(String matchGender) {
		this.matchGender = matchGender;
	}

	public int getOperationHourId() {
		return operationHourId;
	}

	public void setOperationHourId(int operationHourId) {
		this.operationHourId = operationHourId;
	}

	public int getCourtId() {
		return courtId;
	}

	public void setCourtId(int courtId) {
		this.courtId = courtId;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", matchDate=" + matchDate + ", matchApplicantCnt=" + matchApplicantCnt
				+ ", matchLevel=" + matchLevel + ", matchGender=" + matchGender + ", operationHourId=" + operationHourId
				+ ", courtId=" + courtId + "]";
	}
	
	
}
