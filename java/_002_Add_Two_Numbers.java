/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _002_Add_Two_Numbers {
    // example in leetcode book
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
    	if (first == null && second == null) {
    		throw new IllegalArgumentException("the ListNode can't be both null!");
		}
    	ListNode dummyHead = new ListNode(0);
    	ListNode p = first, q= second, curr = dummyHead;
    	// 进位
    	int carry = 0;
    	while (p != null || q!= null) {
    		int x = (p != null) ? p.val : 0;
    		int y = (q != null) ? q.val : 0;
    		// 先算低位，加上上一次的进位
    		int digit = carry + x + y;
    		carry = digit / 10;
    		//初始当前位
    		curr.next = new ListNode(digit % 10);
    		curr = curr.next;
    		if (p != null) p = p.next;
    		if (q != null) q = q.next;
    	}
    	if (carry > 0) {
    		curr.next = new ListNode(carry);
    	}
    	return dummyHead.next;
    }

	public static void main(String[] args) {
		ListNode first = new ListNode(2);
		first.next = new ListNode(4, new ListNode(3));
		ListNode second = new ListNode(5,new ListNode(6,new ListNode(4)));
		_002_Add_Two_Numbers addTwoNumbers = new _002_Add_Two_Numbers();
		ListNode res = addTwoNumbers.addTwoNumbers(first, second);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
    static class ListNode {
    	int val;
    	ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
