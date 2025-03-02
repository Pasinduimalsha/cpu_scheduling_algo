import java.util.*;

class RoundRobin {
    public static void execute(List<Processors> processes, int quantum) {
        Queue<Processors> queue = new LinkedList<>();
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        // Initialize remaining time for all processes
        for (Processors p : processes) {
            p.remainingTime = p.burstTime;
        }

        int time = 0, index = 0;

        while (index < processes.size() || !queue.isEmpty()) {
            while (index < processes.size() && processes.get(index).arrivalTime <= time) {
                queue.add(processes.get(index++));
            }

            if (!queue.isEmpty()) {
                Processors p = queue.poll();
                int executeTime = Math.min(p.remainingTime, quantum);
                time += executeTime;
                p.remainingTime -= executeTime;

                while (index < processes.size() && processes.get(index).arrivalTime <= time) {
                    queue.add(processes.get(index++));
                }

                if (p.remainingTime > 0) {
                    queue.add(p);
                } else {
                    p.completionTime = time;
                    p.turnaroundTime = p.completionTime - p.arrivalTime;
                    p.waitingTime = p.turnaroundTime - p.burstTime;
                }
            } else {
                time++; // CPU idle
            }
        }

        printResults("Round Robin (RR, Quantum = " + quantum + ")", processes);
    }


    public static void printResults(String tittle, List<Processors> processors) {
        System.out.println("\n" + tittle);
        System.out.println("PS\tAT\tBT\tCT\tTAT\tWT");

        double totalWT = 0;

        for(Processors  p: processors){
            totalWT += p.waitingTime;
            System.out.println(p.id + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" +
                    p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
        }
        System.out.println("Average Waiting Time:"+(totalWT / processors.size()));


    }
}
