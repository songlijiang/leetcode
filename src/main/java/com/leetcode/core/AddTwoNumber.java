package com.leetcode.core;

/**
 * @author songlijiang
 * @version 2019/6/14 15:01
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        ListNode index1 = l1;
        ListNode index2 = l2;
        int carry = 0;
        while (index1!=null || index2!=null){
            int v1 = index1==null ?0:index1.val;
            int v2 = index2==null ?0:index2.val;
            int value  = v1+v2+carry;
            int v = value%10;
            carry=value/10;
            ListNode pre = current;
            current = new ListNode(v);
            if(head==null){
                head = current;
            }else {
                pre.next=current;
            }
            if(index1!=null){
                index1 = index1.next;
            }
            if(index2!=null){
                index2 = index2.next;
            }

        }
        if(carry!=0){
            current.next=new ListNode(carry);
        }
        if(head==null){
            return new ListNode(0);
        }
        return head;
    }





    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
