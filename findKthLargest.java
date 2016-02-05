public static int findKthLargest(int[] nums, int k) {
	if (k == 1 || k > nums.length) 
		return -1;
	
	return findKthLargest(nums, 0, nums.length - 1, k);
}

public static int findKthLargest(int[] nums, int start, int end, int k) {
	int pivot = start; // should be chosen randomly
	int left = start;
	int right = end;
	
	while (left <= right) {
		while (left <= right && nums[left] <= nums[pivot]) 
			++left;
		while (left <= right && nums[right] >= nums[pivot])
			--right;
		if (left < right)
			swap(nums, left, right);
	}
	
	swap(nums, pivot, right);
	
	if (k == right + 1) 
		return nums[right];
	else if (k > right + 1) 
		return findKthLargest(nums, right + 1, end, k);
	else 
		return findKthLargest(nums, start, right - 1, k);
}

public static void swap(int[] nums, int a, int b) {
	int temp = nums[a];
	nums[a] = nums[b];
	nums[b] = temp;
}