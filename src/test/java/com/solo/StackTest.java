package com.solo;

/**
 * @Author gaojian
 * @Date 2018/10/17
 */
public class StackTest {
    public static void main(String[] args) {
        //先进后出(LIFO)-stack
        MyStack<String> stack = new MyStack<String>();
        for (String s : "the prefect code".split(" ")) {//LIFO
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }

        System.out.println();
        for (char s : "写了个一句话倒起来说的程序".toCharArray()) {//用例：正话反说
            stack.push(String.valueOf(s));
        }
        while (!stack.empty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
