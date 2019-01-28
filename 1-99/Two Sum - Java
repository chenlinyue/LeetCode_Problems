class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        // Use a hashmap to record the position of numbers
        for (int i = 0; i < nums.length; i++){
            if (pos.containsKey(target - nums[i]) && i != pos.get(target - nums[i])){
                int[] result = {pos.get(target - nums[i]), i};
                return result;
            }
            pos.put(nums[i], i);
            // Put the new number into the list after checking
        }
        int[] result = {-1, -1};
        return result;
    }
}
