import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        Path systemPath = FileSystems.getDefault().getPath("").toAbsolutePath();

        CSVReader reader = new CSVReaderBuilder(
            new FileReader(systemPath + "\\" + "data.csv")
            ).build();

        String[] rows;

        String[] columnNames = reader.readNext();

        Graph graph = new Graph();

        while((rows = reader.readNext()) != null){
            Integer edgeCounter = 1;

            while(edgeCounter < 7){
                Node node1 = new Node(rows[0]);
                Node node2 = new Node(rows[edgeCounter]);

                Edge edge = new Edge(
                    node1,
                    node2,
                    columnNames[edgeCounter]
                );

                graph.addEdge(edge);

                edgeCounter += 1;
            }
        }

        ArrayList<String> test = new ArrayList<String>();
        test.add("SF-1");
        test.add("evening");

        Integer filtered = graph.count(test);

        System.out.println(filtered);
    }
}