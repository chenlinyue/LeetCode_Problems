class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, l = nums.length;
        for (int k = 0; k < l; k++){
            if (nums[k] != val){
                nums[i++] = nums[k];
            }
        }
        return i;
    }
}
