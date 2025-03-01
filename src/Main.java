import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Processors> processes = Arrays.asList(
                new Processors("P1", 1,6,3),
                new Processors("P2",3,8,1),
                new Processors("P3",5, 2, 5),
                new Processors("P4",7,4,2),
                new Processors("P5", 9,5,4 )
        );

        FCFS.execute(new ArrayList<>(processes));
    }



}