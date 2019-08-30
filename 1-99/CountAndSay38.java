public String countAndSay(int n) {
    List<StringBuffer> seqs = new ArrayList<>();
    StringBuffer ini = new StringBuffer("1");
    seqs.add(ini);

    for (int i = 1; i < n; i++){
        seqs.add(new StringBuffer(""));
        char pre = ' ';
        int count = 0;
        for (int j = 0; j < seqs.get(i - 1).length(); j++){
            if (pre == ' '){
                pre = seqs.get(i - 1).charAt(j);
                count++;
            }else if (seqs.get(i - 1).charAt(j) == pre){
                count++;
            }else{
                seqs.get(i).append(count + "" + pre);
                count = 1;
                pre = seqs.get(i - 1).charAt(j);
            }
        }
        seqs.get(i).append(count + "" + pre);
    }
    return seqs.get(seqs.size() - 1).toString();
}
