package juv.study.algorithm.programmers.stackqueue;

import java.util.*;

public class Printer {

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    static class Solution {
        public int solution(int[] priorities, int location) {

            PrinterQueue printerQueue = new PrinterQueue();

            for (int i = 0; i < priorities.length; i++) {
                printerQueue.add(i, priorities[i]);
            }

            int order = 1;
            while (true) {
                Task task = printerQueue.poll();
                if (task == null) break;
                if (task.idx == location) break;
                order++;
            }

            return order;
        }

        class PrinterQueue {
            Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Task> taskQueue = new LinkedList<>();

            public void add(int idx, int priority) {
                priorityQueue.add(priority);
                taskQueue.add(new Task(idx, priority));
            }

            public Task poll() {
                if (priorityQueue.isEmpty() || taskQueue.isEmpty()) {
                    return null;
                }

                Integer targetPriority = priorityQueue.poll();

                while (true) {
                    Task task = taskQueue.poll();
                    if (task.priority == targetPriority) {
                        return task;
                    }
                    taskQueue.add(task);
                }
            }
        }

        class Task {
            int idx;
            int priority;

            public Task(int idx, int priority) {
                this.idx = idx;
                this.priority = priority;
            }
        }
    }
}
