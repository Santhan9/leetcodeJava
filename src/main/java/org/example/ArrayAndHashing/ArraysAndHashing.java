package org.example.ArrayAndHashing;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysAndHashing {

    public static boolean validAnagrams(String s , String t){
        //check whether the strings length is equal
        if(s.length() != t.length()){
            return false;
        }
        //store each character of string in map with occurances
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }
 boolean result = ! map.values().stream().anyMatch(e->e!=0);
        return result;

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }

        }
return res;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS= new String(c);
            if(! map.containsKey(sortedS)){
                map.put(sortedS,new ArrayList<>());
            }
            map.get(sortedS).add(s);
        }
       return new ArrayList<>(map.values());

    }
}
