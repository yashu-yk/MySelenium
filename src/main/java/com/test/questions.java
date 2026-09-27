package com.test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class questions {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 12345678;
		String str = ""+number;
		int beg = 0;
		int end = str.length()-1;
		boolean flag = true;
		int ch=end; char first;
		
		
		while(beg<ch) {
			str=str.substring(beg,ch-1)+str.substring(ch,end)+str.charAt(ch-1);
			    System.out.println(str);
			ch--;
		}
		System.out.println(str);
		
		
//		String A = "1111110";  //to check palindrome
//		int beg = 0;
//		int end = A.length()-1;
//		boolean flag = true;
//		
//		while(beg<=end) {
//			if(A.charAt(beg)==A.charAt(end)) {
//				beg++; end--;
//			}
//			else {
//			flag = false;
//			break;
//			}
//		}
//		
//		if(flag == true) {
//			System.out.println(A +" " +"is Palindrome");
//		}
//		else {System.out.println(A +" " +"is not Palindrome");}
		
		
		String A = "aaaeeiioooouuuaaaiiibbbb";  // to count vowels
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<A.length(); i++){
        	if(A.charAt(i)=='a'||A.charAt(i)=='e'||A.charAt(i)=='i'||A.charAt(i)=='o'||A.charAt(i)=='u') {
            if(map.containsKey(A.charAt(i))){
                map.put(A.charAt(i), map.get(A.charAt(i))+1);
            }
            else
                 map.put(A.charAt(i), 1);
        }
        }
        String res = "";
        for(char vowel : map.keySet()){
            res = res+vowel+map.get(vowel);
        }
        System.out.println(res);
	}
}
