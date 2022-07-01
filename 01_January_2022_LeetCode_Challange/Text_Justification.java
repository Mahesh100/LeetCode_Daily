class Solution {
    public List<String> fullJustify(String[] words, int L) {
         List<String> res = new ArrayList<String>();
         if (words == null || words.length == 0) {
             return res;
         }
         
         int left = 0;
         int right = 0;
         int letterCnt = 0;
         while (right < words.length) {
             int spaceCnt = right - left;
             int length = words[right].length();
             if (letterCnt + length + spaceCnt > L) {
                 res.add(oneLine(words, L, left, right - 1, letterCnt));
                 left = right;
                 letterCnt = 0;
             } else {
                 right++;
                 letterCnt += length;
             }
         }
         res.add(leftJustify(words, L, left, right - 1));
         
         return res;
     }
     
     private String oneLine(String[] words, int L, int left, int right, int letterCnt) {
         if (right - left == 0) {
             return leftJustify(words, L, left, right);
         }
         String averageSpace = new String(new char[(L-letterCnt)/(right-left)]).replace("\0", " ");
         int extraSpaceCnt = (L - letterCnt) % (right - left);
         StringBuilder res = new StringBuilder();
         for (int i = left; i <= right; i++) {
             res.append(words[i]);
             if (i != right) {
                 res.append(averageSpace);
             }
             if (extraSpaceCnt-- > 0) {
                 res.append(" ");
             }
         }
         return res.toString();
     }
     
     private String leftJustify(String[] words, int L, int left, int right) {
         StringBuilder res = new StringBuilder();
         for (int i = left; i <= right; i++) {
             res.append(words[i]);
             if (i != right) {
                 res.append(" ");
             }
         }
         while (res.length() < L) {
             res.append(" ");
         }
         return res.toString();
     }
 }
 