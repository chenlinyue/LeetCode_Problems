public int minSubArrayLen(int s, int[] nums) {
    int l = nums.length;
    if (l <= 0) return 0;
    int i = 0, j = 0, minLen = Integer.MAX_VALUE;
    int sum = 0;

    while (j < l){
        sum += nums[j++];

        while (sum >= s){
            sum -= nums[i++];
            minLen = Math.min(minLen, j - i + 1);
        }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
