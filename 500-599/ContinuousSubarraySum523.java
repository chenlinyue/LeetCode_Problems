/*
In this function, we use go over the nums array once and store their sum starting from the left.
When can use the subtraction of two sums to get the sum of the middle period.
If the sum of this period (sum2 -  sum1) is n * k, then sum2 and sum1 share the same mod k result.
We use a map to store the mod k result sum and its position, if mod k result happens again, and the length is bigger than 1,
the result is true.
*/

public boolean checkSubarraySum(int[] nums, int k) {
    if (nums.length < 2) return false;
    for (int i = 0; i < nums.length - 1; i++){
        if (nums[i] == 0 && nums[i + 1] == 0)
            return true;
    }

    if (k == 0) return false;

    Map<Integer, Integer> periodSum = new HashMap<>();

    periodSum.put(0, -1);

    int sum = 0;
    for (int i = 0; i < nums.length; i++){
        sum += nums[i];
        sum %= k;
        if (periodSum.containsKey(sum)){
            if (i - periodSum.get(sum) > 1)
                return true;
        }else{
            periodSum.put(sum, i);
        }
    }
    return false;
}
