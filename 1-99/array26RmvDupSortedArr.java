class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int n: nums){
            if (res == 0 || n > nums[res - 1]){
                nums[res++] = n;
            }
        }
        return res;
    }
}
