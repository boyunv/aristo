import java.util.Stack;
/*
* 相同点：都返回栈顶的值。
    不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
* */
public class stack_min {
    private  Stack<Integer> stackData;
    private  Stack<Integer> stackMin;
    public stack_min(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }
    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum<=this.getmin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    //所有元素的出栈
    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack  is empty");
        }
        int value=this.stackData.pop();
        if(value==this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }
    //获取最小值
    private int getmin() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack  is empty");
        }
        //出栈
        return this.stackMin.peek();
    }

}
