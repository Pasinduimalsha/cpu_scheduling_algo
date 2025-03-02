import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.*;

public class SJF {

    public static void execute(List<Processors> processors){
        processors.sort(Comparator.comparingInt(p -> p.arrivalTime));
        List<Processors> readyQueue = new ArrayList<>();
        List<Processors> completedProcesses = new ArrayList<>();
        int time = 0;

        while(!processors.isEmpty() || !readyQueue.isEmpty()){
            for (Iterator<Processors> it = processors.iterator(); it.hasNext();){
                Processors p = it.next();
                if(p.arrivalTime <= time){
                    readyQueue.add(p);
                    it.remove();
                }else break;;
            }

            if (!readyQueue.isEmpty()){
                readyQueue.sort(Comparator.comparingInt(p -> p.burstTime));
                Processors p = readyQueue.remove(0);
                time += p.burstTime;
                p.completionTime = time;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
                completedProcesses.add(p);

            }else {
                time++;
            }

        }


      printResults("Shortest Job First (SJF)", completedProcesses);
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
