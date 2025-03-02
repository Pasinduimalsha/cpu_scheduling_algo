import java.util.Comparator;
import java.util.List;

public class FCFS {

    public static void execute(List<Processors> processors){

        //Sort the processors by Arrival Time
        processors.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int time = 0;

        for(Processors p : processors){
            if(time < p.arrivalTime){
                time = p.arrivalTime;
            }
            p.completionTime = time + p.burstTime;
            time = p.completionTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
        }

        printResults("First Come First Serve (FCFS)",processors);
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
