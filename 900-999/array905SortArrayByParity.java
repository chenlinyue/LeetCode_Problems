class Solution {
    public int[] sortArrayByParity(int[] A) {
        int front = 0, back = A.length - 1;
        int temp;
        while (front < back){
            while (front < A.length && A[front] % 2 == 0){
                front += 1;
            }
            while (back >= 0 && A[back] % 2 == 1){
                back -= 1;
            }
            if (front < back && front < A.length && back >= 0){
                temp = A[front];
                A[front] = A[back];
                A[back] = temp;
                front += 1;
                back -= 1;
            }
        }
        return A;
    }
}
