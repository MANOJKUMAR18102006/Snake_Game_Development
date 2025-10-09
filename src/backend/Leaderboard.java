package backend;

import java.io.*;
import java.util.*;

public class Leaderboard {

    private static final String FILE_PATH = "scores.txt";

    public static void saveScore(String username, int score) {
        Map<String, Integer> scores = loadScores();

        int previousScore = scores.getOrDefault(username, 0);
        if (score > previousScore) {
            scores.put(username, score);
            saveScores(scores);
        }
    }

    public static List<String> getTopPlayers() {
        Map<String, Integer> scores = loadScores();
        return formatTopPlayers(scores, 5);
    }

    private static Map<String, Integer> loadScores() {
        Map<String, Integer> scores = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String user = parts[0].trim();
                    int value = Integer.parseInt(parts[1].trim());
                    scores.put(user, value);
                }
            }
        } catch (IOException ignored) {}

        return scores;
    }

    private static void saveScores(Map<String, Integer> scores) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Failed to save scores: " + e.getMessage());
        }
    }

    private static List<String> formatTopPlayers(Map<String, Integer> scores, int limit) {
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(scores.entrySet());
        sorted.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(limit, sorted.size()); i++) {
            var entry = sorted.get(i);
            result.add((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }

        return result;
    }
}
