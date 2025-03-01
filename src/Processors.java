public class Processors {

    String id;
    int arrivalTime, burstTime, priority, remainingTime;
    int completionTime, waitingTime, turnaroundTime;

    public Processors(String id, int arrivalTime, int burstTime, int priority){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
