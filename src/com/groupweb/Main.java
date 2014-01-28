package com.groupweb;

import java.util.List;


public class Main {
	
	public static void main(String[] args) {
		User michael = new User("Michael Auderer");
		User basil = new User("Basil Scruby");
		User paul = new User("Paul Ka");
		User malik = new User("Malik Kennedy");
		
		michael.addFriend(basil);
		michael.addFriend(paul);
		
		basil.addFriend(paul);
		basil.addFriend(malik);
		basil.addFriend(michael);
		
		paul.addFriend(basil);
		paul.addFriend(malik);
		paul.addFriend(michael);
		
		System.out.print("Michael: ");
		System.out.println(michael.getFriendNames());
		System.out.print("Basil: ");
		System.out.println(basil.getFriendNames());
		System.out.print("Paul: ");
		System.out.println(paul.getFriendNames());
		System.out.println();
		System.out.println();
		
		System.out.print("Basil & Paul's mutual friends: ");
		System.out.print("[");
		List<User> mutuals = basil.findMutuals(paul);
		for (User user: mutuals) {
			System.out.print(user.name + ", ");
		}
		System.out.println("]");
	}
}
