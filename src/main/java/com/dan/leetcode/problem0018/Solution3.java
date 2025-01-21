package com.dan.leetcode.problem0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time: O(NlogN)
// space: O(1)
public class Solution3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 4) {
            return list;
        }

        Arrays.sort(nums);

        // improved based on 3-sum
        int layer4 = 0;
        while (layer4 < nums.length) {

            // @note: below is causing me trouble when convert for to while
            // 			in while, here "layer4" is never updated for case like {0,0,0,0}
            // if(layer4 > 0 && nums[layer4] == nums[layer4 - 1]) continue;
            if (layer4 > 0 && nums[layer4] == nums[layer4 - 1]) {
                layer4++;
            }

            // hold one pointer, other two pointer moving
            int ancher = layer4 + 1;
            while (ancher < nums.length) {

                int i = ancher + 1;
                int j = nums.length - 1;

                while (i < j) {

                    int sum = nums[layer4] + nums[ancher] + nums[i] + nums[j];

                    if (sum == target) {

                        // @note: Arrays.asList()
                        list.add(Arrays.asList(nums[layer4], nums[ancher], nums[i], nums[j]));

                        // @note: dont forget move pointers
                        i++;
                        j--;

                        // @note: optimization. above i,j is updated already, compare with previous position
                        while (i < j && nums[i] == nums[i - 1]) {
                            i++;
                        }
                        while (j > i && nums[j] == nums[j + 1]) {
                            j--;
                        }

                    } else if (sum < target) {
                        i++;

                        // @note: same here, possibly updated already, note i-1 or i+1
                        while (i < j && nums[i] == nums[i - 1]) {
                            i++;
                        }

                    } else {
                        j--;

                        // @note: same here, possibly updated already, note i-1 or i+1
                        while (j > i && j + 1 < nums.length && nums[j] == nums[j + 1]) {
                            j--;
                        }

                    }
                }

                ancher++;

                // optimize for 2nd pointer
                while (ancher > layer4 && ancher < nums.length && nums[ancher] == nums[ancher - 1]) {
                    ancher++;
                }

            }

            layer4++;

            // optimize for 2nd pointer
            while (layer4 < nums.length && nums[layer4] == nums[layer4 - 1]) {
                layer4++;
            }
        }

        return list;
    }
}
