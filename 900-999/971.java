class Solution {
    public int[] sortedSquares(int[] A) {
        int[] squares = new int[A.length];
        int minPos = 0;
        if (A[0] >= 0){
            for (int j = 0; j < A.length; j++){
                squares[j] = abs(A[j]) * abs(A[j]);
            }
            return squares;
        }
        for (int k = 1; k < A.length; k++){
            if (abs(A[k]) <= abs(A[minPos])){
                minPos = k;
            }else{
                break;
            }
        }
        squares[0] = abs(A[minPos]) * abs(A[minPos]);
        int leftMove = minPos - 1; int rightMove = minPos + 1;
        for (int i = 1; i < A.length; i++){
            if (leftMove >= 0 && rightMove < A.length){
                if (abs(A[leftMove]) < abs(A[rightMove])){
                    squares[i] = abs(A[leftMove]) * abs(A[leftMove]);
                    leftMove -= 1;
                }else{
                    squares[i] = abs(A[rightMove]) * abs(A[rightMove]);
                    rightMove += 1;
                }
            }else if (leftMove >=0){
                squares[i] = abs(A[leftMove]) * abs(A[leftMove]);
                leftMove -= 1;
            }else{
                squares[i] = abs(A[rightMove]) * abs(A[rightMove]);
                rightMove += 1;
            }
        }
        return squares;
    }
    private int abs(int num){
        return num >= 0 ? num : -num;
    }
}
