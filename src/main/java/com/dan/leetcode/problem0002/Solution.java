package com.dan.leetcode.problem0002;

/*
Intuition
We will want to save the summation in the first linked list. So, we keep track of the two linked list within a while loop and if we encounter the numbers we add them and then put the result into that current position in the first linked list. and while adding if one of them is longer than the other, we check the other and create a linked list node at the end of that first list.

Approach
Complexity
Time complexity:
Time complexity is O(n) since we will have to loop the maximum length of the two.

Space complexity:
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = l1;
        int sum = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){ //if we have a value add it to sum
                sum += l1.val;
            }
            if(l2 != null){ //same as above
                sum += l2.val;
            }
            l1.val = sum%10;
            sum /= 10;
            if(l1.next == null && ((l2 != null && l2.next != null) || sum != 0)){
                //checks if we have a carryover or the other linked list has more values
                l1.next = new ListNode(0);
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null) // we have to check since one of them might be longer
                l2 = l2.next;
        }

        return start;
    }
}
