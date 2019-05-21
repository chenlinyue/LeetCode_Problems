public int[] plusOne(int[] digits) {
    int l = digits.length;
    int i;

    for (i = l - 1; i >= 0; i--){
        if (digits[i] < 9){
            digits[i]++;
            return digits;
        }
        digits[i] = 0;
    }
    
    int[] res = new int[l + 1];
    res[0] = 1;
    for (int k = 0; k < l; k++){
        res[k + 1] = digits[k];
    }
    return res;
    }
