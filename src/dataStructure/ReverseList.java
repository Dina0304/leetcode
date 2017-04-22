package dataStructure;

import org.w3c.dom.Node;

public class ReverseList {
	class NodeList{
		int val;
		NodeList next;
		public NodeList(int val) {
			this.val = val;
		}
	}
	
	public static NodeList reverse(NodeList node) {
		NodeList head = node;
		NodeList prev = null;
		NodeList next = null;
		
		while (node!=null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		head = prev;
		
		return head;
	}

	public static void main(String[] args) {
		NodeList n1 = new ReverseList().new NodeList(7);
		NodeList n2 = new ReverseList().new NodeList(3);
		NodeList n3 = new ReverseList().new NodeList(1);
		
		NodeList node = n1;
		node.next = n2;
		node.next.next = n3;
		node.next.next.next = null;
		
		System.out.println("after:");
		NodeList reverseList = reverse(node);
		while (reverseList != null) {
			System.out.print(reverseList.val+" ");
			reverseList = reverseList.next;
		}
	}

}
