class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] str = S.toCharArray();
        int result = 0;
        for (char j: J.toCharArray()){
            for (char s: str){
                if (s == j){
                    result += 1;
                }
            }
        }
        return result;
    }
}
