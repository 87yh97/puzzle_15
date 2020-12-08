package puzzle;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(8);
        for (int i = 0; i < 10; i++) {
            System.out.println(pq.poll());
        }

    }
}
