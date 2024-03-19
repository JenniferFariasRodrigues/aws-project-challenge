import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProjectApplicationTests {
    public static void main(String[] args) {
        final String apiUrl = "http://localhost:8080/transactions"; // URL da API POST
        final String transactionData = "{\"id\": \"1\", \"amount\": 100, \"type\": \"credit\"}"; // Define os 100 para teste

        for (int i = 0; i < 100; i++) {
            try {
                @SuppressWarnings("deprecation")
				URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                conn.getOutputStream().write(transactionData.getBytes());

                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("Transaction " + i + " created successfully.");
                } else {
                    System.out.println("Failed to create transaction " + i + ". Response code: " + responseCode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
