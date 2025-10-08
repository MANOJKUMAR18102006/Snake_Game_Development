package backend;

import java.io.*;
import java.util.*;

public class UserAuth {
    private static HashMap<String, String> userMap = new HashMap<>();
    private static final String FILE_PATH = "users.txt";

    // Load users when class is loaded
    static {
        loadUsersFromFile();
    }

    // Read users from the file
    private static void loadUsersFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    userMap.put(username, password);
                }
            }

            reader.close();
        } catch (IOException e) {
            // File might not exist yet, that's fine
            System.out.println("No users found. Starting fresh.");
        }
    }

    // Save users to file
    private static void saveUsersToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH));
            for (Map.Entry<String, String> entry : userMap.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    // Login check
    public static boolean login(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        }
        return false;
    }

    // Register new user
    public static boolean register(String username, String password) {
        if (userMap.containsKey(username)) {
            return false; // already exists
        }

        userMap.put(username, password);
        saveUsersToFile();
        return true;
    }
}
