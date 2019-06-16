public int findMin(int[] nums) {
    int l = nums.length;
    if (l == 0) return 0;
    int left = 0, right = l - 1;
    int mid;
    while (left < right){
        mid = (left + right) / 2;
        // right is unsorted
        if (nums[mid] > nums[right]) left = mid + 1;
        // left is unsorted
        else if (nums[mid] < nums[left]) right = mid;
        // nums[mid] <= nums[right] && nums[mid] >= nums[left]
        else
            right--;
        }
    return nums[left];
}
