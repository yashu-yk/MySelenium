package javaQuestions;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class vowelsQ1 {
    public static void main(String[] args){
       // i/p- aaddccdd  o/p- a3d2c2d2

        String str = "aaassrreeddaaivbbblouu";
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for(int i=0; i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }

        System.out.println("Frequecny of alphabets");
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }

        System.out.println("Frequecny of vowels");
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(char ch :set){
            if(map.containsKey(ch)){
                System.out.println(ch +" : "+ map.get(ch));
            }
        }

        System.out.println("Printing Duplicates");
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey());
            }
        }
    }
}
