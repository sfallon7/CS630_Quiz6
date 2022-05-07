import java.util.Comparator;
import java.util.PriorityQueue;

public class Quiz6 {

    static class Process{
        public String pid;
        public int priority;
        public int burstTime;
        public int pNum;
        public char type;
        public int arrival;
        public int tickCount = 0;
        public int completionTime = 0;
        public Process(String pid, int priority, int burstTime, int pNum){
            this.pid = pid;
            this.priority = priority;
            this.burstTime = burstTime;
            this.pNum = pNum;
        }
        public Process(){}
        public Process(int arrivalTime){
            this.arrival= arrivalTime;
        }
        public Process spawnProcess(int arrivalTime , String pid) {
            return null;
        }
    }
    static class ProcessA extends Process {
        public ProcessA() {
            this.type = 'A';
            this.priority = 2;
            this.burstTime = 10;
        }
        public ProcessA(int arrivalTime, String pid) {
            this.type = 'A';
            this.arrival = arrivalTime;
            this.pid = pid;
            this.priority = 2;
            this.burstTime = 10;
        }
        @Override
        public Process spawnProcess(int arrivalTime , String pid) {
            return new ProcessB(arrivalTime , pid);
        }
    }
    static class ProcessB extends Process {
        public ProcessB() {
            this.type = 'B';
            this.priority = 3;
            this.burstTime = 7;
        }
        public ProcessB(int arrivalTime, String pid) {
            this.type = 'B';
            this.priority = 3;
            this.burstTime = 7;
            this.arrival = arrivalTime;
            this.pid = pid;
        }
        @Override
        public Process spawnProcess(int arrivalTime , String pid) {
            return new ProcessC(arrivalTime , pid);
        }
    }
    static class ProcessC extends Process {
        public ProcessC() {
            this.priority = 1;
            this.burstTime = 5;
            this.type = 'C';
        }
        public ProcessC(int arrivalTime, String pid) {
            this.type = 'C';
            this.priority = 1;
            this.burstTime = 5;
            this.arrival = arrivalTime;
            this.pid = pid;
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
        int tick = 0;
        int processCount = 2;
        int TQ = 4;
        int timePassed = 0;

        // Instantiate 3 Processes
        Process proc1A = new ProcessA(0, "P1" );
        Process proc2B = new ProcessB(0, "P2");

        // Instantiate Priority Queue
        PriorityQueue<Process> priQueue = new PriorityQueue<Process>(1 , new ProcessComparator());
        priQueue.add(proc1A);
        priQueue.add(proc2B);
        while(!priQueue.isEmpty()) {
            Process p = priQueue.remove();
            int runningTime = p.burstTime >= TQ ? TQ : p.burstTime;
            for (int i = 1; i <= runningTime; i++){
                timePassed += i;
                if (i%3 == 0) {
                    Process newProcess = p.spawnProcess(timePassed, "p" + Integer.toString(processCount));
                    if(newProcess != null)
                    {
                        processCount++;
                        priQueue.add(newProcess);
                    }
                }
                if (timePassed%3 == 0){
                    
                    //add signal count
                }
            }
            p.burstTime -= runningTime;
            if (p.burstTime > 0){
                priQueue.add(p);
            }
            System.out.println(" " + p.pid + " " + " " + p.type);
        }
        // while(!priQueue.isEmpty()) {
        //     Process currentProcess = priQueue.peek();
        //     tick += 1;
        //     if (tick%3==0 && tick != 0) {
        //         priQueue.add(currentProcess.spawnProcess(tick, "P" + Integer.toString(processCount)));
        //     }
        //     if ((tick%TQ == 0 && tick != 0)) {
        //         currentProcess.burstTime = currentProcess.burstTime - 4;
        //         //16
        //         //p1 = 1
        //         //p1 = -3
        //         //p2 = tick -3
        //     }
        // }
    }
}