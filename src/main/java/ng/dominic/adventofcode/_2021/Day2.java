package ng.dominic.adventofcode._2021;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ng.dominic.adventofcode.util.Reader.read;

public class Day2 {

    private Day2() {
    }

    public static int task1(String fileName) throws IOException {
        try (var reader = read(fileName)) {
            Map<String, Integer> directionAndDistance = new HashMap<>();
            for (String line; (line = reader.readLine()) != null; ) {
                var distance = Integer.parseInt(line.substring(line.length() - 1));
                var direction = line.substring(0, 1);
                directionAndDistance.put(direction, directionAndDistance.containsKey(direction)
                        ? directionAndDistance.get(direction) + distance
                        : distance);
            }
            var horizontalPosition = directionAndDistance.get("f");
            var depth = directionAndDistance.get("d") - directionAndDistance.get("u");
            return horizontalPosition * depth;
        }
    }

    public static int task2(String fileName) throws IOException {
        try (var reader = read(fileName)) {
            int aim = 0;
            Map<String, Integer> depthAndDistance = new HashMap<>(Map.of("depth", 0, "distance", 0));
            for (String line; (line = reader.readLine()) != null; ) {
                int distance = Integer.parseInt(line.substring(line.length() - 1));
                if (line.startsWith("d")) {
                    aim += distance;
                }
                if (line.startsWith("u")) {
                    aim -= distance;
                }
                if (line.startsWith("f")) {
                    depthAndDistance.put("depth", depthAndDistance.get("depth") + aim * distance);
                    depthAndDistance.put("distance", depthAndDistance.get("distance") + distance);
                }
            }
            return depthAndDistance.get("depth") * depthAndDistance.get("distance");
        }
    }
}
