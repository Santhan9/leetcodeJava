package org.example;

import org.example.ArrayAndHashing.ArraysAndHashing;

public class Main {
    public static void main(String[] args) {
        boolean r = ArraysAndHashing.validAnagrams("anagram","nagaram");
        System.out.println(r);
        int[] a = {3,3};
        int[] res = ArraysAndHashing.twoSum(a,6);
        System.out.println(res[0]+","+res[1]);
        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ArraysAndHashing.groupAnagrams(anagrams));
    }
}