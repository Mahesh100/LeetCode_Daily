class Solution {
    public String removeDuplicateLetters(String s) {
        int [] cnt = new int [26];
        for (int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(pos) > s.charAt(i)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }

        return s.length() == 0 ? "": s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}