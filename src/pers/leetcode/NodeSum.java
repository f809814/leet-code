package pers.leetcode;

/**
 * @author fu
 * @date 2018/7/28 - 15:23
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode fi = res;
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            res.next = new ListNode((res.val + l1.val + l2.val) / 10);
            res.val = (res.val + l1.val + l2.val) % 10;
            l1 = l1.next;
            l2 = l2.next;
            temp = res;
            res = res.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                res.next = new ListNode((res.val + l2.val) / 10);
                res.val = (res.val + l2.val) % 10;
                l2 = l2.next;
                temp = res;
                res = res.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                res.next = new ListNode((res.val + l1.val) / 10);
                res.val = (res.val + l1.val) % 10;
                l1 = l1.next;
                temp = res;
                res = res.next;
            }
        }
        if (res.val == 0)
            temp.next = null;
        return fi;
    }
}

public class NodeSum {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
