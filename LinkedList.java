import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N = 0;

	public static class Node<Item> {
		Item item;
		Node next;

	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public static void add(LinkedList list, Node n) {
		n.next = list.first;
		list.first = n;
		if (list.N == 1) {
			list.last = list.first;
		} else {
			Node temp = list.first;
			while (temp.next != null) {
				temp = temp.next;
			}
			list.last = temp;
		}
		list.N++;
	}

	public void insert(Item item) {
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = first;
		first = newNode;
		N++;
	}

	// 1.3.19
	public void removeLast() {
		if (!isEmpty()) {
			if (first.next == null) {
				first = null;
				N--;
			} else {

				Node temp = first;
				while (temp.next.next != null) {
					temp = temp.next;
				}
				N--;
				temp.next = null;
			}
		}
	}

	// 1.3.20
	public void delete(int k) {

		if (isEmpty()) {

			System.out.println("The list is empty.");

		} else if (k > N) {

			System.out.println("Element at " + k + " does not exist.");

		} else if (N == k) {

			removeLast();

		} else if (k == 1) {

			first = first.next;
			N--;

		} else {

			Node temp = first;
			int count = 2;
			while (count < k) {
				temp = temp.next;
				count++;
			}
			N--;
			temp.next = temp.next.next;
		}

	}

	// 1.3.21
	public boolean find(LinkedList list, String key) {

		Node temp = list.first;

		if (!isEmpty()) {
			while (temp != null) {
				if (temp.item.equals(key)) {
					return true;
				}
				temp = temp.next;
			}
		} else {

			System.out.println("The list is empty.");

		}

		return false;
	}

	// 1.3.24
	public void removeAfter(Node node) {

		if (!isEmpty()) {
			if (first.next == null || node == last) {
				return;
			}
			Node temp = first;
			while (temp != node) {
				if (temp.next == null) {
					return;
				}
				temp = temp.next;
			}
			temp.next = temp.next.next;
			N--;

		}
	}

	// 1.3.25
	public void insertAfter(Node targetNode, Node insertNode) {
		if (!isEmpty()) {
			if (first.next == null) {
				if (targetNode == first)
					first.next = insertNode;
				N++;

			}

			if (targetNode != null && insertNode != null) {

				Node temp = first;
				while (temp != targetNode && temp != null) {
					temp = temp.next;

				}

				if (temp == targetNode) {

					insertNode.next = temp.next;
					temp.next = insertNode;
					N++;

				} else {

					System.out.println("No Target Found!");
				}
			}
		} else {
			System.out.println("The list is empty.");
		}

	}

	// 1.3.26
	public void remove(LinkedList<String> list, String key) {
		if (!isEmpty()) {

			while (list.first.item.equals(key) && list.first != null) {
				list.first = list.first.next;
				list.N--;
			}

			Node temp1 = list.first;
			Node temp2 = null;

			while (temp1 != null) {
				if (temp1.item.equals(key)) {

					temp2.next = temp1.next;
					temp1 = temp1.next;
					list.N--;

				} else {
					temp2 = temp1;
					temp1 = temp1.next;
				}
			}

		} else {
			System.out.println("The list is empty.");
		}
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	class ListIterator implements Iterator<Item> {

		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = (Item) current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();

		n1.item = "F";
		n2.item = "F";
		n3.item = "F";
		n4.item = "A";

		add(list, n1);
		add(list, n2);
		add(list, n3);
		add(list, n4);

		list.remove(list, "F");

		for (String s : list) {
			System.out.println(s);

		}
	}
}
