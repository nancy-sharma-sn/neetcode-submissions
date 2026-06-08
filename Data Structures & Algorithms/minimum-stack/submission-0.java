class MinStack {
     private Stack <Integer> minStack;
    
    public MinStack() {
        minStack = new Stack<>();  
    }
    
    public void push(int val) {
        minStack.push(val);
        
    }
    
    public void pop() {
        minStack.pop();
        
    }
    
    public int top() {

        return minStack.peek();
        
    }
    
    public int getMin() {
        Stack<Integer>tmp = new Stack<>();
        int mini = minStack.peek();

        while(!minStack.isEmpty()){
            mini = Math.min(mini,minStack.peek());
            tmp.push(minStack.pop());
        }
        while(!tmp.isEmpty()){
            minStack.push(tmp.pop());
        }
        return mini;
    }
}
