class Solution {
    public String toLowerCase(String str) {
        char[] strArr = str.toCharArray();
        for(int i = 0; i < strArr.length; i++){
            if (strArr[i] >= 'A' && strArr[i] <= 'Z'){
                strArr[i] = (char)(strArr[i] - 'A' + 'a');
            }
        }
        return new String(strArr);
    }
}
