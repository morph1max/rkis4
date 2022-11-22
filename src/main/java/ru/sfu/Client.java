package ru.sfu;


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
                "http://localhost:8080/washing/13",
                String.class
        );
    }

    public static String addWashing() {
        Washing washing = new Washing(
                13,
                5,
                18,
                "Apple",
                "Good",
                "Russia"
        );

        return rest.postForObject(
                "http://localhost:8080/washing/add",
                washing,
                String.class
        );
    }

    public static String patchWashing() {
        Washing washing = new Washing(
                13,
                53,
                183,
                "Nokia",
                "Bad",
                "USA"
        );

        return rest.patchForObject(
                "http://localhost:8080/washing/put/0",
                washing,
                String.class,
                "washing"
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

        System.out.println("Patch washing = " + patchWashing());

        System.out.println("One washing id== = " + getOneWashing());

        deleteWashing();
        System.out.println("Delete successfully!");

        System.out.println("All washings = " + getListWashing());
    }
}
