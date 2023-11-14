package com.nongguin.model.dto;

import java.util.Date;

public class Friend {
	private int friendId;
	private int friendToUser;
	private int friendFromUser;
	private boolean friendisFriend;
	private Date friendReqDate;
	private Date friendAccDate;
	
	public Friend() {
		
	}
	
	public Friend(int friendId, int friendToUser, int friendFromUser, boolean friendisFriend, Date friendReqDate,
			Date friendAccDate) {
		super();
		this.friendId = friendId;
		this.friendToUser = friendToUser;
		this.friendFromUser = friendFromUser;
		this.friendisFriend = friendisFriend;
		this.friendReqDate = friendReqDate;
		this.friendAccDate = friendAccDate;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public int getFriendToUser() {
		return friendToUser;
	}

	public void setFriendToUser(int friendToUser) {
		this.friendToUser = friendToUser;
	}

	public int getFriendFromUser() {
		return friendFromUser;
	}

	public void setFriendFromUser(int friendFromUser) {
		this.friendFromUser = friendFromUser;
	}

	public boolean isFriendisFriend() {
		return friendisFriend;
	}

	public void setFriendisFriend(boolean friendisFriend) {
		this.friendisFriend = friendisFriend;
	}

	public Date getFriendReqDate() {
		return friendReqDate;
	}

	public void setFriendReqDate(Date friendReqDate) {
		this.friendReqDate = friendReqDate;
	}

	public Date getFriendAccDate() {
		return friendAccDate;
	}

	public void setFriendAccDate(Date friendAccDate) {
		this.friendAccDate = friendAccDate;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", friendToUser=" + friendToUser + ", friendFromUser=" + friendFromUser
				+ ", friendisFriend=" + friendisFriend + ", friendReqDate=" + friendReqDate + ", friendAccDate="
				+ friendAccDate + "]";
	}
}
