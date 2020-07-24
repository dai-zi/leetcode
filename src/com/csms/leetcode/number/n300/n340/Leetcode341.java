package com.csms.leetcode.number.n300.n340;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//扁平化嵌套列表迭代器
//中等
public class Leetcode341 {

    public static void main(String[] args) {
    }
}

class NestedIterator implements Iterator<Integer> {
    Stack<List<NestedInteger>> stack = new Stack<>();
    Stack<Integer> ptrStack = new Stack<>();
    List<NestedInteger> curList;
    int ptr = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        curList = nestedList;
    }

    @Override
    public Integer next() {
        // hasNext()后，指针一定是指在下一个Integer上的，所以直接取就好了
        if (hasNext()) {
            return curList.get(ptr++).getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        // 当List遍历到结尾时，要跳出递归
        while (ptr == curList.size() && !stack.isEmpty()) {
            ptr = ptrStack.pop();
            curList = stack.pop();
        }
        // 最后一个List遍历完了，就结束了
        if (ptr == curList.size()) {
            return false;
        }

        // 判断是Integer还是List
        if (curList.get(ptr).isInteger()) {
            return true;
        } else {
            ptrStack.push(ptr + 1);
            stack.push(curList);
            curList = curList.get(ptr).getList();
            ptr = 0;
            return hasNext();
        }
    }
}

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 