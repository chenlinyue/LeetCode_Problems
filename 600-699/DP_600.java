class Solution {
    public int findIntegers(int num) {
        String str = Integer.toBinaryString(num);
        int l = str.length();
        int a[] = new int[l]; int b[] = new int[l];
        a[0] = 1; b[0] = 1;
        for (int i = 1; i < l; i++){
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        
        int result = a[l - 1] + b[l - 1];
        
        for (int j = 0; j < l - 1; j++){
            if (str.charAt(j) == '1' && str.charAt(j + 1) == '1'){
                break;
            }else if (str.charAt(j) == '0' && str.charAt(j + 1) == '0'){
                result -= b[l - j - 2];
            }
        }
        
        return result;
    }
}
