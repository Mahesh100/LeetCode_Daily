class Node {
    private char key;
    private int value;
    
    public Node(char key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public char getKey() {
        return key;
    }
    
    public int getValue() {
        return value;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        
        if (s.isEmpty() || s.length() < k){
            return s;
        }
        
        Deque<Node> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()){
            if (stack.isEmpty()) {
                stack.push(new Node(c, 1));
            } else {
                if (stack.peek().getKey() == c){
                    Node temp = stack.pop();
                    stack.push(new Node(c, temp.getValue() + 1));
                } else {
                    stack.push(new Node(c, 1));
                }
            }

            if (stack.peek().getValue() == k) {    
                stack.pop();  
            } 
        }
        
        StringBuilder sb = new StringBuilder();
        for (Node node : stack){
            for (int i = 0; i < node.getValue(); i++){
                sb.append(node.getKey());
            }
        }
        
        return sb.reverse().toString();
        
    }
}