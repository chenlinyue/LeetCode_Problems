/* the lesson learned here is that if we need to check an overflow's happening, we need to do the pre-check instead 
of after the overflow where we assume that is gonna happen, the value is already lost by then.
*/

public int myAtoi(String str) {
        // get the string that trim off the starting spaces
        if (str.length() == 0) return 0;
        int i = 0;
        for (; i < str.length(); i++){
            if(str.charAt(i) != ' ') break;
        }
        StringBuffer noSpaces = new StringBuffer(str.substring(i));
        if(noSpaces.length() == 0) return 0;
        
        // get the optional + or - or nothing
        int ab = 1;
        if (noSpaces.charAt(0) == '+'){
            noSpaces.deleteCharAt(0);
        }else if (noSpaces.charAt(0) == '-'){
            ab = -1;
            noSpaces.deleteCharAt(0);
        }
        
        // get the number or return 0 if it's not a number
        // the overflow shoulb be forecasted, since the data is already changed if an overlfow happens
        int result = 0;
        
        for (int j = 0; j < noSpaces.length(); j++){
            
            if (noSpaces.charAt(j) < '0' || noSpaces.charAt(j) > '9'){
                return ab * result;
            }
            // judge if a new add number would cause an overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (noSpaces.charAt(j) - '0') > Integer.MAX_VALUE % 10)){
                if (ab == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            
            result = result * 10 + (noSpaces.charAt(j) - '0');
        }
        return ab * result;
    }
