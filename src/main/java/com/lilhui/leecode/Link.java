package com.lilhui.leecode;

import java.util.*;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/25 14:23
 */
public class Link {

    public class Node {

       public Node next;

       public int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }

    public void linkquchong() {
        Node node7 = new Node(null, 3);
        Node node6 = new Node(node7, 7);
        Node node5 = new Node(node6, 2);
        Node node4 = new Node(node5, 3);
        Node node3 = new Node(node4, 5);
        Node node2 = new Node(node3, 1);
        Node node1 = new Node(node2, 2);
        Stack<Node> stack = new Stack<>();
        Node stackNode = node1;
        while(stackNode != null) {
            stack.push(stackNode);
            stackNode = stackNode.next;
        }
        Map<Integer, Boolean> nodeMap = new HashMap<Integer, Boolean>();
        Node resultNode = new Node(null, stack.pop().value);
        nodeMap.put(resultNode.value, true);
        Node startNode = new Node(resultNode, 0);
        while (!stack.isEmpty()) {
            //resultNode遍历判断 stackNode值是否已经存在
            Node currentNode = new Node(null, stack.pop().value);
            if (nodeMap.get(currentNode.value) == null) {
                resultNode.setNext(currentNode);
                resultNode = currentNode;
            }
            nodeMap.put(currentNode.value, true);
        }
        startNode = startNode.next;
        while (startNode != null) {
            System.out.print(startNode.value);
            startNode = startNode.next;
        }

    }

    public static void main(String[] args) {
        //Link link = new Link();
        //Link.Node node = new Node(null, 0);
        //link.linkquchong();
        Integer value = 1;
        Long value2 = 1L;
        System.out.println(value.equals(value2));
        List animals = new ArrayList();
        animals.add(new Dog());
        animals.add(new Cat());
        new Link().play(animals);
    }

    public void play(List<Dog> cats) {
        System.out.println(cats);
    }
}
