package ep195.application;

import ep195.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        String path = "src/ep195/input.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            Set<LogEntry> logs = new HashSet<>();
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(" ");
                logs.add(new LogEntry(fields[0], Date.from(Instant.parse(fields[1]))));
                line = br.readLine();
            }

            System.out.println("Total users: " + logs.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
