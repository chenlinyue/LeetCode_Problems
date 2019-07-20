public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    if (len == 0) return 0;

    int[] lowerLeft = new int[len];
    int[] lowerRight = new int[len];

    lowerLeft[0] = -1;
    lowerRight[len - 1] = len;

    for (int i = 1; i < len; i++){
        int p = i - 1;
        while (p >= 0 && heights[p] >= heights[i]){
            p = lowerLeft[p];
        }
        lowerLeft[i] = p;
    }
    for (int j = len - 2; j >= 0; j--){
        int p = j + 1;
        while(p < len && heights[p] >= heights[j]){
            p = lowerRight[p];
        }
        lowerRight[j] = p;
    }

    int max = 0;
    for (int i = 0; i < len; i++){
        max = Math.max(max, heights[i] * (lowerRight[i] - lowerLeft[i] - 1));
    }
    return max;
}
