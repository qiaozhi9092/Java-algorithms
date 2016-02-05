  public static int duplicate(int numbers[]) {
		if (numbers == null)
			throw new IllegalArgumentException("numbers is null");
		
		int length = numbers.length;

		int bigSum = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > length - 2)
				throw new IllegalArgumentException("Invalid numbers.");
			bigSum += numbers[i];
		}
		// only 0 to n - 2
		int smallSum = ((length - 2) * (length - 1)) / 2;

		return bigSum - smallSum;
	}