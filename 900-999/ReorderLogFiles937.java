public String[] reorderLogFiles(String[] logs) {

    Comparator<String> myCmp = new Comparator<String>(){
        @Override
        public int compare(String s1, String s2){
            int s1st = s1.indexOf(' ');
            int s2st = s2.indexOf(' ');
            char s1cmp = s1.charAt(s1st + 1);
            char s2cmp = s2.charAt(s2st + 1);

            if (s1cmp <= '9'){
                if (s2cmp <= '9') return 0;
                return 1;
            }
            if (s2cmp <= '9') return -1;

            int cmp = s1.substring(s1st + 1).compareTo(s2.substring(s2st + 1));
            if (cmp == 0) return s1.substring(0, s1st).compareTo(s2.substring(0, s2st));
            return cmp;
        }
    };
    Arrays.sort(logs, myCmp);
    return logs;
}
