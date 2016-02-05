int rotatedBinarySearch(int[] array, int key) {
	int start = 0;
	int end = array.length - 1;
	
	while (start <= end) {
		// avoid overflow, same as mid = (start + end) / 2
		int mid = start + (end - start) / 2;
		
		if (array[mid] == key)
			return mid;
		
		if (array[start] <= array[mid]) {
			if (array[start] <= key && key < array[mid])
				end = mid - 1;
			else
				start = mid + 1;
		} else {
			if (array[mid] < key && key <= array[end]) 
				start = mid + 1;
			else
				end = mid - 1;
		}
	}
	
	return -1;
}	