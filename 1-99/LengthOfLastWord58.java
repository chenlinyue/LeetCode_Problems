public int lengthOfLastWord(String s) {
    char[] str = s.toCharArray();

    int length = 0;
    boolean start = true;
    for (int i = 0; i < str.length; i++){
        if (str[i] == ' '){
            start = true;
        }else if (!start){
            length++;
        }else{
            length = 1;
            start = false;
        }
    }
    return length;
}
