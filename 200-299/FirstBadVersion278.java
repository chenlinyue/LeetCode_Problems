public int firstBadVersion(int n) {
    if (n <= 0) return 0;
    int low = 1, high = n;
    int mid;
    while (low < high){
        mid = low + (high - low) / 2;
        /* Here is an important tip: DO NOT use mid = (low + high) / 2
        cuz it might cause overflow that eventually lead to "Time Limit Exceeded"
        */
        if (isBadVersion(mid) == false) low = mid + 1;
        else high = mid;
    }
    return high; // it's ok to return high or low here
}
