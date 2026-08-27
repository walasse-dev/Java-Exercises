package ep198.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        String path = "src/ep198/input.csv";
        Map<String, Integer> votes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)){
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.printf("%s: %d\n", key, votes.get(key));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
