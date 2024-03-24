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

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i,map.get(i)+1);
        }
        List<Integer> collect = map.entrySet().stream().sorted((e1,e2)-> e2.getValue()-e1.getValue()).limit(k).map(e -> e.getKey()).collect(Collectors.toList());
 int[] res = new int[k];
        for(int i =0;i<k;i++){
            res[i]=collect.get(i);
        }
return res;
    }

    public int[] productExceptSelf(int[] nums) {


return null;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return map.get(b)-map.get(a);
            }
        });
        int[] ans = new int[k];
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i :map.keySet()){
            pq.add(i);
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;




    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for(int uniqueNum : freqMap.keySet()) {
            int currFreq = freqMap.get(uniqueNum);
            if(buckets[currFreq] == null) {
                buckets[currFreq] = new ArrayList<>();
            }
            buckets[currFreq].add(uniqueNum);
        }

        int index = 0;
        int[] result = new int[k];
        for(int freq = nums.length; freq > 0; freq--) {
            if(buckets[freq] == null) continue;
            for(int i = 0; i < buckets[freq].size(); i++) {
                result[index] = buckets[freq].get(i);
                index += 1;
                k -= 1;
                if(k == 0) {
                    return result;
                }
            }
        }

        return result;
    }


        public List<List<String>> groupAnagrams1(String[] strs) {
            List<List<String>> res = new AbstractList<List<String>>() {
                List<List<String>> result = null;

                public List<String> get(int index) {
                    if (result == null) {
                        init();
                    }
                    return result.get(index);
                }

                public int size() {
                    if (result == null) {
                        init();
                    }
                    return result.size();
                }

                private void init() {
                    Map<String, List<String>> anaMap = new HashMap<>();

                    for (String str: strs) {
                        char[] arr = new char[26];
                        char[] strArr = str.toCharArray();
                        for (int i = 0; i < strArr.length; i++) {
                            arr[strArr[i] - 'a']++;
                        }

                        String strKey = String.valueOf(arr);
                        anaMap.computeIfAbsent(strKey, k -> new ArrayList<>());
                        anaMap.get(strKey).add(str);
                    }

                    result = new ArrayList<>(anaMap.values().size());
                    for (Map.Entry<String, List<String>> anaToList: anaMap.entrySet()) {
                        result.add(anaToList.getValue());
                    }
                }
            };
            return res;
        }



}
