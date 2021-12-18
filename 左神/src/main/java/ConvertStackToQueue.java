import java.util.Stack;

public class ConvertStackToQueue {
    //编写一个类,实现两个栈实现队列的crud
    private Stack <Integer>  stackPush;
    private Stack <Integer>  stackPop;

    public  ConvertStackToQueue(){
        stackPush=new Stack<Integer>();
        stackPop=new Stack<Integer>();
    }
    public void add(int pushInt){
        stackPush.push(pushInt);
    }
    public int poll(){
        if(stackPop.empty()&&stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    public int peek(){
        if (stackPop.empty()&&stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

}
