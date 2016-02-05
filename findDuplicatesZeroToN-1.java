public static int duplicate(int[] numbers) {
	int length = numbers.length;
	for (int i = 0; i < numbers.length; i++) {
		if (numbers[i] < 0 || numbers[i] > length - 1)
			throw new IllegalArgumentException("Invalid numbers");
	}

	for (int i = 0; i < numbers.length; i++) {
		while (numbers[i] != i) {
			if (numbers[i] == numbers[numbers[i]]) {
				return numbers[i];
			} else {
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
	}
	throw new IllegalArgumentException("No duplicates found");
}