package offer;

import java.util.HashMap;

public class List1 {
	public static class ListNode{
		ListNode next;
		int val;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public static void deleteDups(ListNode node) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode prevListNode = null;
		while(node!=null) {
			if(map.containsKey(node.val)) {
				prevListNode.next = node.next;
			}else {
				map.put(node.val, 1);
				prevListNode = node;
			}
			node = node.next;
		}
	}

	public static void main(String[] args) {
		int[] arr = {3,1,56,3,8,2,2,1,0};
		ListNode node = new ListNode(0);
		ListNode headListNode = node;
		for (int i = 0; i < arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		node = headListNode.next;
		deleteDups(node);
		while (node!=null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}

}
