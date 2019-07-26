public String removeDuplicateLetters(String s) {
    int[] times = new int[26];
    char[] c = s.toCharArray();
    boolean[] visited = new boolean[26];

    if (s.length() == 0) return "";

    for (int i = 0; i < s.length(); i++){
        times[c[i] - 'a']++;
    }

    Stack<Character> result = new Stack<>();
    for (int i = 0; i < s.length(); i++){
        times[c[i] - 'a']--;
        if (visited[c[i] - 'a'] == true) continue;
        while (!result.isEmpty() && c[i] - 'a' < result.peek() - 'a' 
            && times[result.peek() - 'a'] > 0){
            visited[result.pop() - 'a'] = false;
        }
        result.push(c[i]);
        visited[c[i] - 'a'] = true;
    }

    StringBuilder res = new StringBuilder();
    while (!result.isEmpty()){
        res.append(result.pop());
    }

    return res.reverse().toString();
}

// The time complexity for this solution is O(n)
