class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                int num = Integer.parseInt(s.substring(j, j + i));
                if (num > high) {
                    return res;
                }
                if (num >= low) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}