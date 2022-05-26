import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        Path systemPath = FileSystems.getDefault().getPath("").toAbsolutePath();

        CSVReader reader = new CSVReaderBuilder(new FileReader(systemPath + "\\" + "data.csv")).build();

        String[] rows;

        ArrayList<Node> orders = new ArrayList<Node>();

        while(( rows = reader.readNext()) != null){
            orders.add(new Node(rows[0]));
            System.out.println(rows[0]);
        }

        // System.out.println(rows[0]);
        // System.out.println(rows[1]);
        // System.out.println(rows[2]);
        // System.out.println(rows[3]);
        // System.out.println(rows[4]);
        // System.out.println(rows[5]);
        // System.out.println(rows[6]);
    }
}