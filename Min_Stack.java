import java.util.*;

class Min_Stack{
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	node head;

	private class node{
		public int val;
		public node next;
		
		public node(int val){
			this.val = val;
			this.next = null;
			list.add(val);
		}
	}
	
	public static void main(String[] args){
		Min_Stack ms = new Min_Stack();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number to put on stack  (0 exits) > ");
		int t = in.nextInt();
		while(t != 0){
			ms.push(t);
			System.out.print("Enter number to put on stack  (0 exits) > ");
			t = in.nextInt();
		}
		ms.print();
		System.out.println(ms.pop());
		ms.print();
		System.out.println(ms.getMin());
	}
	
	private void push(int val){
		if(head == null){
			node n = new node(val);
			head = n;
		}
		else{
			node n = new node(val);
			n.next = head;
			head = n;
			list.add(val);
		}
	}
	
	private int pop() throws EmptyStackException{
		if(head != null){
			node temp = head;
			head = head.next;
			list.remove(list.indexOf(temp.val));
			return temp.val;
		}
		return -1;
	}
	
	private int top(){
		return head.val;	
	}
	
	private int getMin(){
		return Collections.min(list);
	}

	private void print(){
		printList(head);
		System.out.println();
	}
	
	private void printList(node head){
		if(head != null){
			System.out.print(head.val + ", ");
			printList(head.next);
		}
	}
}
