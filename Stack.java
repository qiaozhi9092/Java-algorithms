import java.util.*;

interface Stack<E> {
	public boolean isEmpty();

	public int size();

	public E peek() throws EmptyStackException;

	public E pop() throws EmptyStackException;

	public void push(E element);
}

class EmptyStackException extends RuntimeException {
	public EmptyStackException() {
		super();
	}
}

class ArrayStack<E> implements Stack<E> {

	private static final int DEFAULT_CAPACITY = 10;

	private E[] array;

	private int size;

	public ArrayStack(int cap) {
		array = (E[]) new Object[cap];
	}

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size <= 0)
			return true;
		else
			return false;
	}

	public E peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();

		return array[size - 1];
	}

	public void push(E element) {
		if (size + 1 >= array.length)
			array = Arrays.copyOf(array, array.length + array.length * 2);
		array[size++] = element;
	}

	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		E element = array[--size];
		array[size] = null;

		return element;
	}
}

class NodeStack<E> implements Stack<E> {

	class Node<E> {
		public E value;
		public Node<E> next;

		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}

		public Node(E value) {
			this(value, null);
		}
	}

	protected Node<E> top;
	protected int size;

	public NodeStack() {
		size = 0;
		top = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	public void push(E element) {
		Node<E> newTop = new Node<E>(element, top);
		top = newTop;
		size++;
	}

	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		E temp = top.value;
		top = top.next;
		size--;
		return temp;
	}

	public E peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		return top.value;
	}
}

public class Practice {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<Integer>();
		Stack<Integer> nodeStack = new NodeStack<Integer>();

		for (int i = 0; i < 100; i++) {
			stack.push(i);
			nodeStack.push(i);
		}
		System.out.println(stack.size() == 100);
		System.out.println(nodeStack.size() == 100);
		System.out.println(stack.peek() == 99);
		System.out.println(nodeStack.peek() == 99);

		for (int i = 1; i <= 100; i++) {
			System.out.println(stack.pop() == 100 - i);
			System.out.println(nodeStack.pop() == 100 - i);
		}

		try {
			System.out.println(stack.pop());
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty");
		}

	}
}