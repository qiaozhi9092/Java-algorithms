class BinaryTree {
	public int value;
	public BinaryTree left;
	public BinaryTree right;
	
	public BinaryTree(int value) {
		this.value = value;
	}
	
	public void inorder() {
		if (left != null) 
			left.inorder();
		System.out.println(value + ", ");
		if (right != null) {
			right.inorder();
		}
	}
	
	public void iterativeInorder() {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		
		BinaryTree current = this;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				System.out.println(current.value + ", ");
				current = current.right;
			}
		}
	}
	public void preorder() {
		System.out.println(this.value + ", ");
		if (left != null) 
			left.preorder();
		if (right != null)
			right.preorder();
	}
	
	public void iterativePreorder() {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		
		BinaryTree current = this;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				System.out.println(current.value + ", ");
				if(current.right != null)
					stack.push(current.right);
				current = current.left;
			} else {
				current = stack.pop();
			}
		}
	}
	
	public void postorder() {
		if (left != null) 
			left.postorder();
		if (right != null)
			right.postorder();
		System.out.println(value + ", ");
	}
	
	public void iterativePostorder() {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
	
		stack.push(this);
		BinaryTree prev = null;
		
		while(!stack.isEmpty()) {
			BinaryTree current = stack.peek();
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null)
					stack.push(current.left);
				else if (current.right != null) 
					stack.push(current.right);
			} else if (current.left == prev) {
				if (current.right != null) 
					stack.push(current.right);
			} else {
				System.out.println(current.value + ", ");
				stack.pop();
			}
			prev = current;
		}
	}
	
	public void levelorder() {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		
		queue.add(this);
		
		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.println(node.value + ", ");
			if (node.left != null) 
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}
}