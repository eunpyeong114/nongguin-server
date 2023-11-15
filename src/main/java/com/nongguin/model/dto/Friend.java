package com.nongguin.model.dto;

public class Friend {
	private int friendId;
	private int friendToUser;
	private int friendFromUser;
	private boolean friendIsFriend;

	public Friend() {

	}

	public Friend(int friendId, int friendToUser, int friendFromUser, boolean friendisFriend) {
		super();
		this.friendId = friendId;
		this.friendToUser = friendToUser;
		this.friendFromUser = friendFromUser;
		this.friendIsFriend = friendisFriend;
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
		return friendIsFriend;
	}

	public void setFriendisFriend(boolean friendisFriend) {
		this.friendIsFriend = friendisFriend;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", friendToUser=" + friendToUser + ", friendFromUser=" + friendFromUser
				+ ", friendisFriend=" + friendIsFriend + "]";
	}

}
