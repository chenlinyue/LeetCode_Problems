public boolean search(int[] nums, int target) {
        int l = nums.length;
        if (l <= 0) return false;
        int left = 0, right = l - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            
            // left side sorted
            if (nums[mid] > nums[left]){
                if (nums[mid] > target){
                    if (nums[left] > target) left = mid + 1;
                    else right = mid - 1;
                }else left = mid + 1;
            }
            // right side sorted
            else if (nums[mid] < nums[left]){
                if (nums[mid] < target){
                    if (nums[right] < target) right = mid - 1;
                    else left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else left++;
        }
        return false;
    }
