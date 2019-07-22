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

/*
At first, I used String[] instead of StringBuffer[], and this lead to a very high consumption of memory. The reason is that
the length of String cannot be changed, so everytime I use += to update it, the real action is that another new String is
created. But if we use StringBuffer and StringBuffer.append(), this problem is solved. But remember converting StringBuffer
to String (StringBuffer.toString()) in the end.
*/
