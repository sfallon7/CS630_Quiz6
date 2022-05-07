import java.util.Comparator;
import java.util.PriorityQueue;

public class Quiz6 {

    static class Process{
        String pid;
        int priority;
        int burstTime;
        int pNum;
        int arrival; 

        public Process(String pid, int priority, int burstTime, int pNum){
            this.pid = pid;
            this.priority = priority;
            this.burstTime = burstTime;
            this.pNum = pNum;
        }
    }
    static class ProcessComparator implements Comparator<Process> {

        @Override
        public int compare(Quiz6.Process o1, Quiz6.Process o2) {
            if(o1.priority > o2.priority) {
                return 1;
            }
            if(o1.priority < o2.priority) {
                return -1;
            }
            if(o1.priority == o2.priority) {
                if(o1.arrival < o2.arrival) {
                    return 1;
                }
                if(o1.arrival > o2.arrival) {
                    return -1;
                }
                if(o2.arrival == o1.arrival) {
                    if(o1.burstTime < o2.burstTime) {
                        return 1;
                    }
                    if(o1.burstTime > o2.burstTime) {
                        return -1;
                    }
                    if(o1.burstTime == o2.burstTime) {
                        // pid
                    }
                }
            }
            return 0;
        }

    }
    public static void main(String[] args) {
        int tick;
        int totalTime;
        // Instantiate 3 Processes
        Process proc1A = new Process("pA", 15, 10, 1);
        Process proc2B = new Process("pB", 1, 7, 2);
        Process proc1B = new Process("pR", 7, 2, 3);
        Process proc1C = new Process("pZ", 4, 2, 3);
        Process proc1D = new Process("pM", 14, 2, 3);

        // Instantiate Priority Queue
        PriorityQueue<Process> priQueue = new PriorityQueue<Process>(1 , new ProcessComparator());
        priQueue.add(proc2B);
        priQueue.add(proc1B);
        priQueue.add(proc1C);
        
        priQueue.add(proc1A);
        priQueue.add(proc1D);
        for (Process a : priQueue) {
            System.out.println(a.pid);
        }
        System.out.println("----------------");
        priQueue.remove();
        for (Process a : priQueue) {
            System.out.println(a.pid);
        }
        // System.out.println(priQueue.peek().pid);
    }
}