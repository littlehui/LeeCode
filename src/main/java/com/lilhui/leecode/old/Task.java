package com.lilhui.leecode.old;

import java.sql.Statement;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/14 20:38
 */
public class Task {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int core = 0;
        int taskCount = 0;
        core = Integer.parseInt(in.nextLine());
        taskCount = Integer.parseInt(in.nextLine());
        String taskStrs = in.nextLine();
        int[] tasks = new int[taskCount];
        String[] taskArray = taskStrs.split(" ");
        List<Stack<Integer>> listStack = new ArrayList<Stack<Integer>>(taskArray.length);
        for (int i=0; i<taskArray.length; i++) {
            int taskItems = Integer.parseInt(taskArray[i]);
            Stack<Integer> stack = new Stack<>();
            for (int j=0;j<taskItems;j++) {
                stack.push(1);
            }
            listStack.add(stack);
        }
        System.out.println(runTime(core, taskCount, listStack));
    }

    public static int runTime(int core, int taskCount, List<Stack<Integer>> stacks) {
        int runTimes = 0;
        while (true) {
            int concurrentCount = concurrentCount(core, stacks);
            for (int i=0;i<concurrentCount;i++) {
                int runCount = 0;
                for (int j=0;j<taskCount;j++) {
                    if (!stacks.get(j).isEmpty()) {

                        stacks.get(j).pop();
                        runCount++;
                        if (runCount == concurrentCount) {
                            break;
                        }
                    }
                }
                runTimes++;
            }
            if (isAllEmpty(stacks)) {
                break;
            }
        }

        return runTimes;
    }

    public static int concurrentCount(int core, List<Stack<Integer>> stacks) {
        int notEmptyStack = 0;
        for (Stack<Integer> stack : stacks) {
            if (!stack.isEmpty()) {
                notEmptyStack++;
            }
        }
        if (notEmptyStack > core) {
            return core;
        } else {
            return notEmptyStack;
        }
    }

    public static boolean isAllEmpty(List<Stack<Integer>> stacks) {
        boolean isAllEmpty = true;
        for (Stack<Integer> stack : stacks) {
            isAllEmpty &= stack.isEmpty();
        }
        return isAllEmpty;
    }
}
