package javaQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class Q3 {

	public static void main(String[] args) {
		// check anagram
		//Deque<Character> stack = new ArrayDeque<>();
		HashMap<Character, Integer> map = new HashMap<>();
		String one = "abab";
		String two = "aabb";
		
		for(char ch: one.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}
			else {
				map.put(ch,1);
			}
		}


		for(char ch: two.toCharArray()) {
			if(!map.containsKey(ch)) {
				System.out.println("Strings are not Anagram");
			}
			else {
				map.put(ch,map.get(ch)-1);
			}
		
		if(map.get(ch)==0) {
			map.remove(ch);
		}
		
	}
		if(map.isEmpty()) {
			System.out.println("Strings are Anagram");
		}
}
}
