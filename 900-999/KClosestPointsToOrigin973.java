public int[][] kClosest(int[][] points, int K) {
    int len = points.length;
    int left = 0, right = len - 1;

    while (left < right){
        int mid = quickSort(points, left, right);
        if (mid == K) break;
        if (mid > K) right = mid - 1;
        else if (mid < K) left = mid + 1;
    }

    return Arrays.copyOfRange(points, 0, K);
}

public int quickSort(int[][] points, int left, int right){
    int[] pivot = points[left];
    while (left < right){
        while (right > left && compare(pivot, points[right]) < 0) right--;
        points[left] = points[right];
        while (left < right && compare(pivot, points[left]) >= 0) left++;
        points[right] = points[left];
    }
    points[left] = pivot;
    return left;
}

private int compare(int[] pointA, int[] pointB){
    return pointA[0] * pointA[0] + pointA[1] * pointA[1] 
        - pointB[0] * pointB[0] - pointB[1] * pointB[1];
}

// This is like a transformation of quicksort
