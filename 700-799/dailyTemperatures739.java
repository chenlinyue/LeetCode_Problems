public int[] dailyTemperatures(int[] T) {
    int len = T.length;
    int[] res = new int[len];
    Stack<Integer> highT = new Stack<>();

    for (int i = 0; i < len; i++){
        while (!highT.isEmpty() && T[highT.peek()] < T[i]){
            int index = highT.pop();
            res[index] = i - index;
        }
        highT.push(i);
    }

    return res;
}
