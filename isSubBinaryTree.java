public static boolean isSubTreeRef(BinaryTree t1, BinaryTree t2)  {
	if (t2 == null) 
		return true;
	if (t1 == null)
		return false;
	return (t1 == t2) || isSubTreeRef(t1.left, t2) || isSubTreeRef(t1.right, t2);
}

public static boolean isSubTreeValue(BinaryTree t1, BinaryTree t2) {
	if (t2 == null) 
		return true;
	if (t1 == null)
		return false;
		
	if (t1.value == t2.value) 
		if (isSubTreeValue(t1.left, t2.left) && isSubTreeValue(t1.right, t2.right))
			return true;
	return isSubTreeValue(t1.left, t2) || isSubTreeValue(t1.right, t2);
}