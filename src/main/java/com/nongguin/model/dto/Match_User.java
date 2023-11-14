package com.nongguin.model.dto;

public class Match_User {
	private int matchId;
	private int userId;
	
	public Match_User() {
		
	}

	public Match_User(int matchId, int userId) {
		super();
		this.matchId = matchId;
		this.userId = userId;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Match_User [matchId=" + matchId + ", userId=" + userId + "]";
	}
}
