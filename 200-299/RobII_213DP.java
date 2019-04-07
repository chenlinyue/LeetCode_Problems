class Solution {
    public int rob(int[] nums) {
        if (nums.length > 3){
            int[] numsFirstOff = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++){
                numsFirstOff[i] = nums[i + 1];
            }
            int[] numsWithFirst = new int[nums.length - 3];
            for (int j = 0; j < nums.length - 3; j++){
                numsWithFirst[j] = nums[j + 2];
            }
            return Math.max(robPart(numsFirstOff), nums[0] + robPart(numsWithFirst));
        }else if (nums.length > 0){
            int max = 0;
            for (int k: nums){
                if (k > max) max = k;
            }
            return max;
        }else {
            return 0;
        }
    }
    
    private int robPart(int[] nums){
        if (nums.length > 0){
            int rob = 0, notRob = 0;
            int temp;
            for (int i = 0; i < nums.length; i++){
                temp = rob;
                rob = notRob + nums[i];
                notRob = Math.max(temp, notRob);
            }
            return Math.max(rob, notRob);
        }
        else{
            return 0;
        }
    }
}
