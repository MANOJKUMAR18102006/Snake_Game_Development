package backend;

import java.util.*;
import java.io.*;

public class UserAuth {
    private static HashMap<String, String> users = new HashMap<>();
    private static final String FILE_PATH = "users.txt";

    static {
        loadUsers();
    }

    private static void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No saved users yet.");
        }
    }

    private static void saveUsers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                pw.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, password);
        saveUsers();
        return true;
    }
}
