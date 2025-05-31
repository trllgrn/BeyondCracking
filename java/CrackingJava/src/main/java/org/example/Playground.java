package org.example;
import java.util.*;
import java.io.*;

public class Playground {
    //A class to quickly run Java code from wherever
    public static void main(String[] args) {
        System.out.println("Let's PLay!");
        // Example usage
        int[] testArray = {1, 2, 3, 4, 5};
        System.out.println("Testing array utilities:");
        printArray(testArray);
        
        ListNode list = createLinkedList(testArray);
        System.out.println("Created linked list from array");
    }

    // Utility method to print arrays
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    // Utility method to print 2D arrays
    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    // Utility method to create a LinkedList from array
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    // Common ListNode class used in many LeetCode problems
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    // Common TreeNode class used in many LeetCode problems
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // Utility method to print a LinkedList
    public static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
