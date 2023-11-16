package com.nongguin.model.dto;

import java.sql.Timestamp;

public class SearchResult {
	private int courtId;
	private String courtName;
	private String courtAddress;
	private String courtTel;
	private String courtDes;
	private int courtCapacity;
	private int matchId;
	private Timestamp matchDate;
	private int matchApplicantCnt;
	private String matchLevel;
	private String matchGender;
	// 생성자
	public SearchResult() {
		// TODO Auto-generated constructor stub
	}
	public SearchResult(int courtId, String courtName, String courtAddress, String courtTel, String courtDes,
			int courtCapacity, int matchId, Timestamp matchDate, int matchApplicantCnt, String matchLevel,
			String matchGender) {
		super();
		this.courtId = courtId;
		this.courtName = courtName;
		this.courtAddress = courtAddress;
		this.courtTel = courtTel;
		this.courtDes = courtDes;
		this.courtCapacity = courtCapacity;
		this.matchId = matchId;
		this.matchDate = matchDate;
		this.matchApplicantCnt = matchApplicantCnt;
		this.matchLevel = matchLevel;
		this.matchGender = matchGender;
	}
	
	//getter setter
	public int getCourtId() {
		return courtId;
	}
	public void setCourtId(int courtId) {
		this.courtId = courtId;
	}
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public String getCourtAddress() {
		return courtAddress;
	}
	public void setCourtAddress(String courtAddress) {
		this.courtAddress = courtAddress;
	}
	public String getCourtTel() {
		return courtTel;
	}
	public void setCourtTel(String courtTel) {
		this.courtTel = courtTel;
	}
	public String getCourtDes() {
		return courtDes;
	}
	public void setCourtDes(String courtDes) {
		this.courtDes = courtDes;
	}
	public int getCourtCapacity() {
		return courtCapacity;
	}
	public void setCourtCapacity(int courtCapacity) {
		this.courtCapacity = courtCapacity;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public Timestamp getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Timestamp matchDate) {
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
	
	//tostring
	@Override
	public String toString() {
		return "searchResult [courtId=" + courtId + ", courtName=" + courtName + ", courtAddress=" + courtAddress
				+ ", courtTel=" + courtTel + ", courtDes=" + courtDes + ", courtCapacity=" + courtCapacity
				+ ", matchId=" + matchId + ", matchDate=" + matchDate + ", matchApplicantCnt=" + matchApplicantCnt
				+ ", matchLevel=" + matchLevel + ", matchGender=" + matchGender + "]";
	}
	
	
}
