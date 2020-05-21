package dev.algos.snatch.interview_problems.stack;

import java.util.Stack;

public class OnlineStockSpanner {
    Stack<Price> stack;

    public OnlineStockSpanner() {
        stack = new Stack<>();
    }


    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            res += stack.pop().count;
        }
        stack.add(new Price(price, res));
        return res;
    }

    static class Price {
        int price;
        int count;

        public Price(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }
}
