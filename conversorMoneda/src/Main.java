import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/f26e23bccdb5cf5d8a6022f8/latest/";
    private static Gson gson = new Gson();
    private static menu menuConversor = new menu();

    public static void main(String[] args) {
        try {
            menuConversor.menuConvertor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cargarTasasDeCambio(String monedaBase) {
        try {
            String apiUrl = API_BASE_URL + monedaBase;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                menuConversor.parsearJson(response.body());
            } else {
                System.out.println("Error en la API: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}