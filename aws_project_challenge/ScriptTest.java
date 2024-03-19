import org.springframework.web.client.RestTemplate;

public class ScriptTest {

    public static void main(String[] args) {
        final String uri = "http://localhost:8080/transactions"; // URL da API POST local

        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 100; i++) {
            // Transação de exemplo 
            String transaction = "{\"idempotencyId\":\"id" + i + "\",\"amount\":100,\"type\":\"credit\"}";

            // Enviar a requisição POST para a API com os dados da transação
            String result = restTemplate.postForObject(uri, transaction, String.class);
            System.out.println(result);
        }
    }
}
