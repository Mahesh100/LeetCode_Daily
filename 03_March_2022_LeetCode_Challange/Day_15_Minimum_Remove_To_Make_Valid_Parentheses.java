class Solution {
    public String minRemoveToMakeValid(String s) {

        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            if (c == ')') {
                if (!stack.isEmpty()) stack.pop();
                else set.add(i); // given ')' but missing '(', record ')' as false index
            }
        }
        // remaining false indexes of '('
        while (!stack.isEmpty()) set.add(stack.pop());
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}