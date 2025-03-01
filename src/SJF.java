import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SJF {

    public static void execute(List<Processors> processors){
        processors.sort(Comparator.comparingInt(p -> p.arrivalTime));
        List<Processors> readyQueue = new ArrayList<>();
        int time = 0;



    }
}
