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

        ArrayList<Order> orders = new ArrayList<Order>();

        reader.readNext();

        while(( rows = reader.readNext()) != null){
            orders.add(
                new Order(rows[0],
                Integer.parseInt(rows[1]),
                rows[2],
                rows[3],
                rows[4],
                rows[5],
                rows[6])
            );
            System.out.println(rows[0]);
        }

        // System.out.println(rows[0]);
        // System.out.println();
        // System.out.println(rows[2]);
        // System.out.println(rows[3]);
        // System.out.println(rows[4]);
        // System.out.println(rows[5]);
        // System.out.println(rows[6]);
    }
}