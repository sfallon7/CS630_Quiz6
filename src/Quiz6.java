import java.util.Comparator;
import java.util.PriorityQueue;

public class Quiz6 {


    public static void main(String[] args) {
        //Main Function
        int tick;
        int totalTime;

        //Instantiate 3 Processes
        Process proc1A = new Process("pA", 2, 10, 1);
        Process proc2B = new Process("pB", 3, 7, 2);

        //Instantiate Priority Queue
        PriorityQueue<Process> priQueue = new PriorityQueue<Process>();

        //Add Processes to PriorityQue;
        priQueue.add(proc1A);
        priQueue.add(proc2B);

        System.out.println(priQueue.peek());
    }

    static class Process {
        String pid;
        int priority;
        int burstTime;

        int pNum;

        public Process(String pid, int priority, int burstTime, int pNum) {
            this.pid = pid;
            this.priority = priority;
            this.burstTime = burstTime;
            this.pNum = pNum;
        }
    }

    class ProcessComparator implements Comparator<Process> {
        public int compare(Process p1, Process p2) {
            if (p1.priority > p2.priority)
                return 1;
            else if (p1.priority < p2.priority)
                return -1;
            else if (p1.priority == p2.priority)
                return 0;
            return 0;
        }
    }
}