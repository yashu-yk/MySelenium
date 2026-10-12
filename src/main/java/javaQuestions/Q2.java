package javaQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q2 {
    public static void main(String[] args){
        // Swapping two numbers without using third varible
    	int a=1; int b = 50;
    	//swap(a,b);
    	//commonArrayElement();
    	//MoveAllZereosAtTheZereos();
    	secondLargest();
    }
    static void swap(int a, int b) {
    	a=a+b;
    	b=a-b;
    	a=a-b;
    	System.out.println("a" + "=" + a+" and " + "b" + "=" +b);
    }
    
    //Move all zeros to the end of an array
    static void MoveAllZereosAtTheZereos() {
    	int ary[]= {1,0,2,0,4,5,6,10,0,11};
    	int countZeroes=0;
    	List<Integer>list = new ArrayList();
    	for(int i=0;i<ary.length;i++) {
    		if(ary[i]==0) {
    			countZeroes++;
    		}
    	else {
    		list.add(ary[i]);
    	}	
    	}
    	for(int i=1;i<=countZeroes;i++) {
    		list.add(0);
    	}
    	System.out.println(list);
    
    }
    
    //Find the second-largest number in an array
    
    static void secondLargest() {
    	int arr[]= {1,60,20,30,5,1000,90,2000,1500};
    	
    	int secondLargest=Integer.MIN_VALUE;
    	int largest= Integer.MIN_VALUE;
    	
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]>largest) {
    			secondLargest=largest;
    			largest=arr[i];	
    		}
    		else if(arr[i]>secondLargest && arr[i]!=largest){
    			secondLargest=arr[i];
    		}
    	}
    	
    	System.out.println(secondLargest);
    }
    
    //find common element between two array
    static void commonArrayElement() {
    int a[] = {1,2,3,4,5};
    int b[] = {5,6,7,8,9};
    
    HashSet<Integer> seta = new HashSet<>();
    for(int i: a) {
    	seta.add(i);
    }
    
    HashSet<Integer> setb = new HashSet<>();
    for(int i: b) {
    	setb.add(i);
    }
    
    for(int setElement : seta) {
    	if(setb.contains(setElement)) {
    		System.out.println(setElement);
    	}
    }
}
}