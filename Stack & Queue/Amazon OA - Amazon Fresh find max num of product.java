// Amazon OA - Amazon Fresh find max num of products 

class Solusion {
    public int findMaxProducts(int[] numProducts) {
		int n = numProducts.length;
		int[] adjusted = new int[n];
		int[] prevSmaller = new int[n];
		for (int i = 0; i < n; i++) {
			adjusted[i] = numProducts[i] - i;
			prevSmaller[i] = -1;
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = n -1; i >= 0; i--) {
			while (!stack.isEmpty() && adjusted[i] <= adjusted[stack.peek()]) {
				int j = stack.poll();
				prevSmaller[j] = i;
			}
			stack.offer(i);
		}

		int[] dp = new int[n];
		dp[0] = numProducts[0];
		int max = dp[0];
		for (int i = 1; i < n; i++) {
			if (numProducts[i] > numProducts[i - 1]) {
				dp[i] = dp[i - 1] + numProducts[i];
			} else {
				int j = prevSmaller[i];
				int length = Math.min(i - j, numProducts[i]);
				dp[i] = (numProducts[i] + numProducts[i] - length + 1) * length / 2;
				if (j >= 0) {
					dp[i] += dp[j];
				}
			}
			max = Math.max(dp[i], max);
		}

		return max;
	}
	
}