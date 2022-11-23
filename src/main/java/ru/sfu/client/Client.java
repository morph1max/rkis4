package ru.sfu.client;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.sfu.models.Washing;

public class Client {

    static RestTemplate rest = new RestTemplate();

    public static String getListWashing() {
        return rest.getForObject(
                "http://localhost:8080/washing",
                String.class);
    }

    public static String getOneWashing() {
        return rest.getForObject(
                "http://localhost:8080/washing/1",
                String.class
        );
    }

    public static ResponseEntity<String> addWashing() {
        Washing washing = new Washing(
                13,
                5,
                18,
                "Apple",
                "Good",
                "Russia"
        );

        return rest.postForEntity(
                "http://localhost:8080/washing/add",
                washing,
                String.class
        );
    }

    public static void putWashing() {
        Washing washing = new Washing(
                13,
                53,
                183,
                "Nokia",
                "Bad",
                "USA"
        );

        rest.put(
                "http://localhost:8080/washing/put/13",
                washing,
                String.class
        );
    }

    public static void deleteWashing() {
        rest.delete(
                "http://localhost:8080/washing/delete/13"
        );
    }

    public static void main(String[] args) {

        System.out.println("All washings = " + getListWashing());

        System.out.println("Add washing = " + addWashing());

        putWashing();
        System.out.println("Patch washing good!");

        System.out.println("One washing id== = " + getOneWashing());

        deleteWashing();
        System.out.println("Delete successfully!");

        System.out.println("All washings = " + getListWashing());
    }
}
