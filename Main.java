package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Response jokeResponse;
        ObjectMapper objectMapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive number if you want to see a dog image, or a negative number if you want to exit the program: ");
        int number = scanner.nextInt();

        while (number > 0) {
            jokeResponse = objectMapper.readValue(new URL("https://dog.ceo/api/breeds/image/random"), Response.class);

            if(jokeResponse.getStatus().equals("success")) {
                System.out.println(jokeResponse.getMessage());
            } else {
                System.out.println("Sorry, something went wrong");
            }
            System.out.println("Enter a positive number if you want to see a dog image, or a negative number if you want to exit the program: ");
            number = scanner.nextInt();
        }
    }
}