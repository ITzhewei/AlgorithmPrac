package zuoshen.stack2queue;

import java.util.Stack;

/**
 * Created by john(Zhewei) on 2017/1/25.
 * 能拿到最小值的栈
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 方案一
     */
    public void push1(int num) {
        stackData.push(num);
        if (stackMin.isEmpty()) {
            stackMin.push(num);
        } else {
            if (stackMin.peek() >= num) {
                stackMin.push(num);
            }
        }
    }

    public int pop1() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int pop = stackData.pop();
        if (pop == stackMin.peek()) {
            stackMin.pop();
        }
        return pop;
    }

    /**
     * 方案二
     */
    public void push2(int num) {
        stackData.push(num);
        if (stackMin.isEmpty()) {
            stackMin.push(num);
        } else {
            if (stackMin.peek() >= num) {
                stackMin.push(num);
            } else {
                stackMin.push(stackMin.peek());
            }
        }
    }

    public int pop2() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stackMin.peek();
    }

}
