package com.test.algorithm._01queue;

import com.test.common.vo.NodeList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.algorithm
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
// "static void main" must be defined in a public class.

class MyQueue {
    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int p_start;
    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }
    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    };
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }
    /** Get the front item from the queue. */
    public int Front() {
        return data.get(p_start);
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return p_start >= data.size();
    }
};

public class _01Queue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        System.out.println("===========================================");
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        //System.out.println(circularQueue.enQueue(2));
        //System.out.println(circularQueue.enQueue(3));
        //System.out.println(circularQueue.enQueue(4));
        //System.out.println(circularQueue.Rear());
        //System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());


    }

    /**
     * 利用队列实现BFS
     */
    int BFS(NodeList root, NodeList target) {
        Queue<NodeList> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
        int step = 0;       // number of steps neeeded from root to current node
        // initialize  add root to queue;
       queue.add(root);
        // BFS
        while (queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i  =0; i < size; ++i) {
                //Node cur = the first node in queue;
                NodeList cur = queue.poll();
                if (cur.getValue() == target.getValue()){
                    return step;
                }
                for (NodeList next : cur.getChild()) {
                    queue.add(next);
                }
                //remove the first node from queue;
            }
        }
        return -1;          // there is no path from root to target
    }
}

/**
 * 通过size来判断是否为空
 */
class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        head=0;
        tail=-1;
        size=0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
           return false;
        }
        tail = ((++tail)%data.length);
        data[tail]=value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = ((++head)%data.length);
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size == data.length;

    }
}




/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */