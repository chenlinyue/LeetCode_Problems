class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> num = new HashSet<Integer>();
        for(int i: A){
            if (num.contains(i)){
                return i;
            }else{
                num.add(i);
            }
        }
        return -1;
    }
}
