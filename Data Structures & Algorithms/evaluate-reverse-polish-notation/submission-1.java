class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> oper = new Stack<>();

        for(String c: tokens){
            if(c.equals("+")){
                int num1 = oper.pop();
                int num2 = oper.pop();
                int num3 = num1 + num2;
                oper.push(num3);
            }
            else if(c.equals("-")){
                int num1 = oper.pop();
                int num2 = oper.pop();
                int num3 = num2 - num1;
                oper.push(num3);
            }
            else if(c.equals("*")){
                int num1 = oper.pop();
                int num2 = oper.pop();
                int num3 = num1 * num2;
                oper.push(num3);
            }
            else if(c.equals("/")){
                int num1 = oper.pop();
                int num2 = oper.pop();
                int num3 = num2 / num1;
                oper.push(num3);
            }
            else{
                oper.push(Integer.parseInt(c));
            } 
        }
        return oper.pop();
    }
}
