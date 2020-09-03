package com.lx;

import java.util.*;

public class MyCode {
    public static void main (String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target =9;
        MyCode test = new MyCode();

        System.out.println(Arrays.toString(test.twoSum(nums,target)));
        int[]num = {-1, 0, 1, 2, -1, -4};

        System.out.println(Arrays.asList(threeSum(num)));
    }

    //两数
    public int[] twoSum(int[] nums, int target) {
        // expect: O(N)  Hashmap

        // O(n * logn) + O(n) = O(n * logn)
        int[] arr = new int[2];
        Arrays.sort(nums); // O(n * logn)
        int head = 0;
        int tail = nums.length-1;
        while(head<tail){
            // O(n)
            if(nums[head] + nums[tail] == target){
                arr[0] = head;
                arr[1] = tail;
            }if(nums[head] + nums[tail] > target){
                tail--;
            }else{
                head++;
            }
        }
        return arr;
    }


    public static List<List<Integer>> threeSum(int[] num) {

        // step1 : 固定int[] num一个数 i
        // step2: 做two sum(num, 0 - i)
        // time complexity: O(n * n)  + O(n * logn) = O(n * n)  acceptable.
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(num); // O(n * logn)

        for(int i = 0;i < num.length -2;i++){
            // 0(n)
            int head =i+1;
            int tail = num.length -1;
            int sum = num[head] + num[tail];
            while(head < tail){
                // O(n)
                if(num[i] + sum == 0){
                    List<Integer> list =Arrays.asList(num[i],num[head],num[tail]);
                    result.add(list);
                }
                if(num[i] + sum > 0){
                    tail--;
                }
                else{
                    head++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
