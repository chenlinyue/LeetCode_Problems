class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        int a[] = new int[l]; int b[] = new int[l];
        if (s.charAt(0) == '0') return 0;
        a[0] = 1; b[0] = 0;
        for (int i = 1; i < l; i++){
            if (s.charAt(i) != '0'){
                a[i] = a[i - 1] + b[i - 1];
                b[i] = (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && Character.getNumericValue(s.charAt(i)) <= 6)) ? a[i - 1] : 0;
            }
            else{
                if (s.charAt(i - 1) == '2' || s.charAt(i - 1) == '1'){
                    a[i] = 0;
                    b[i] = a[i - 1];
                }else{
                    return 0;
                }
            }
        }
        return a[l - 1] + b[l - 1];
    }
}

// The case which coantains '0' should be carefully considered
