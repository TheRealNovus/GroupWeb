package com.groupweb;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public String name;
	private ArrayList<User> friends;
	
	public User(String name) {
		friends = new ArrayList<User>();
		this.name = name;
	}
	
	public void addFriend(User friend) {
		friends.add(friend);
	}
	
	public void removeFriend(User friend) {
		friends.remove(friend);
	}
	
	public List<String> getFriendNames() {
		List<String> friendNames = new ArrayList<String>();
		for (User friend : friends) {
			friendNames.add(friend.name);
		}
		return friendNames;
	}
	
	public void suggestFriends() {
		if (friends.size() <= 1) {
			return;
		}
		List<User> suggestedFriends = new ArrayList<User>();
		User previousFriend = null;
		for (User friend: friends) {
			if (previousFriend == null) {
				previousFriend = friend;
				continue;
			}
			for (User mutual : findMutuals(previousFriend, friend)) {
				if (!mutual.equals(this)) {
					suggestedFriends.add(mutual);
					System.out.print(mutual.name);
				}
			}
		}
	}
	
	public List<User> findMutuals(User targetFriend) {
		return findMutuals(this, targetFriend);
	}
	
	public List<User> findMutuals(User sourceFriend, User targetFriend) {
		List<User> mutuals = new ArrayList<User>();
		for (User friend: sourceFriend.friends) {
			if (targetFriend.friends.contains(friend)) {
				mutuals.add(friend);
			}
		}
		return mutuals;
	}
}
