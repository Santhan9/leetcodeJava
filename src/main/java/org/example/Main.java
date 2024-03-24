package org.example;

import org.example.ArrayAndHashing.ArraysAndHashing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        boolean r = ArraysAndHashing.validAnagrams("anagram","nagaram");
//        System.out.println(r);
//        int[] a = {3,3};
//        int[] res = ArraysAndHashing.twoSum(a,6);
//        System.out.println(res[0]+","+res[1]);
//        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
//        System.out.println(ArraysAndHashing.groupAnagrams(anagrams));
        int nums[] = {1,1,1,2,3,3};
        int k = 2;
        int[] t =ArraysAndHashing.topKFrequent(nums,k);
        Arrays.stream(t).forEach(System.out::println);

    }
}