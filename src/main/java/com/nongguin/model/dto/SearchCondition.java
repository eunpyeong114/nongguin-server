package com.nongguin.model.dto;

import java.util.Date;

public class SearchCondition {
	private Date date;
	private String region = "none";
	private String gender = "none";
	private int	level = 0;
	
	public SearchCondition() {
		
	}

	public SearchCondition(Date date, String region, String gender, int level) {
		super();
		this.date = date;
		this.region = region;
		this.gender = gender;
		this.level = level;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SearchCondition [date=" + date + ", region=" + region + ", gender=" + gender + ", level=" + level + "]";
	}
	
	
}
