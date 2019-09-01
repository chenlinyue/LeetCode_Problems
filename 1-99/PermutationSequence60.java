public String getPermutation(int n, int k) {
    List<Integer> digits = new ArrayList<>();
    for (int i = 1; i <= n; i++){
        digits.add(i);
    }
    StringBuffer result = new StringBuffer();

    k = k - 1;
    for (int i = 1; i < n; i++){
        int pos = k / factorial(n - i);
        k = k % factorial(n - i);

        result.append(digits.get(pos));
        digits.remove(pos);
        Collections.sort(digits);
    }
    result.append(digits.get(0));

    return result.toString();
}

public int factorial(int n){
    if (n > 0){
        if (n == 1) return 1;
        else return factorial(n - 1) * n;
    }
    return 0;
}
