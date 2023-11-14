package com.nongguin.model.dto;

public class Court {
	private int courtId;
	private String courtName;
	private String courtAddress;
	private String courtTel;
	private String courtDes;
	private int courtCapacity;
	
	public Court() {
		
	}

	public Court(int courtId, String courtName, String courtAddress, String courtTel, String courtDes,
			int courtCapacity) {
		super();
		this.courtId = courtId;
		this.courtName = courtName;
		this.courtAddress = courtAddress;
		this.courtTel = courtTel;
		this.courtDes = courtDes;
		this.courtCapacity = courtCapacity;
	}

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

	@Override
	public String toString() {
		return "Court [courtId=" + courtId + ", courtName=" + courtName + ", courtAddress=" + courtAddress
				+ ", courtTel=" + courtTel + ", courtDes=" + courtDes + ", courtCapacity=" + courtCapacity + "]";
	}
	
}
