public String convert(String s, int numRows) {
    int len = s.length();
    if (len == 0) return "";

    if (numRows == 1) return s;

    int set = 2 * numRows - 2;
    char[] c = s.toCharArray();
    String res = "";

    StringBuffer[] lines = new StringBuffer[numRows];
    for (int i = 0; i < numRows; i++)
        lines[i] = new StringBuffer();

    int i = 0;
    while (i < len){
        for (int idx = 0; idx < numRows && i < len; idx++){
            lines[idx].append(c[i++]);
        }
        for (int idx = numRows - 2; idx > 0 && i < len; idx--){
            lines[idx].append(c[i++]);
        }
    }

    for (int j = 1; j < numRows; j++){
        lines[0].append(lines[j]);
    }     

    return lines[0].toString();
}

/* At first I used String[] instead of StringBuffer[] to store lines of chars, lead to a very high consumption of memory, 
because the length of String can not be changes, and each we use += to update it, actually a whole new String is created.
*/
