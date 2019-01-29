class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (String email: emails){
            String localName = email.substring(0, email.indexOf('@'));
            localName = localName.substring(0, localName.indexOf('+'));
            localName = localName.replaceAll(".", "");
            email = localName.concat(email.substring(email.indexOf('@')));
            map.put(email, 1);
        }
        
        return map.size();
    }
}
