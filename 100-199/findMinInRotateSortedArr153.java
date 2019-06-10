public int findMin(int[] nums) {
    int l = nums.length;
    int left = 0, right = l - 1, mid = -1;
    while (left < right){
        mid = (left + right) / 2;
        if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
        if (nums[left] <= nums[mid] && nums[mid] > nums[right]){
            left = mid + 1;
        }
        else if (nums[mid] < nums[right] && nums[mid] < nums[left])
            right = mid - 1;
        else return nums[left];
    }
    return nums[left];
}
