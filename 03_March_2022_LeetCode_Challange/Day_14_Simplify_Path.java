//Using Stack
/*
class Solution {
    public String simplyPath(String path){
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");
         for(int i=0; i<p.length; i++){
            if(!s.isEmpty() && p[i].equals("..")) s.pop();
            else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) 
                s.push(p[i]);
            
        }
        
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            res.insert(0, s.pop()).insert(0,"/");
        }
        
        return res.toString();
    }
}    */


class Solution {
    public String simplifyPath(String path) {
        String[] arr=path.split("/");
        Stack<String> s=new Stack();
        for(String str: arr){
            if(str.equals(".") || str.length()==0){
                continue;
            }else if(str.equals("..")){
                if(s.size()>0){
                s.pop();
                }
            }else{
                s.push(str);
            }
        }
        String ans="";
        while(s.size()>0){
            ans="/"+s.pop()+ans;
        }
        if(ans.length()==0){
            ans="/";
        }
        return ans;
    }
}