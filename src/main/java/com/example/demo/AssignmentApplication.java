package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Get weather");
        System.out.println("2. Get wind speed");
        System.out.println("3. Get pressure");
        System.out.println("0. Exit");

        int option;

        JSONObject json;
        JSONArray list;

        while (true) {

            System.out.print("Enter option: ");
            option = sc.nextInt();

            if (option == 1 || option == 2 || option == 3) {

                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = sc.next();

                json = readJsonFromUrl("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
                list = json.getJSONArray("list");

                boolean foundData = false;

                for (int i = 0; i < list.length(); i++) {

                    JSONObject forecast = list.getJSONObject(i);
                    String forecastDate = forecast.getString("dt_txt").split(" ")[0];

                    if (forecastDate.equals(date)) {
                        foundData = true;
                        if (option == 1) {
                            double temp = forecast.getJSONObject("main").getDouble("temp");
                            System.out.println("Weather: " + forecast.getJSONArray("weather").getJSONObject(0).getString("main"));
                            System.out.println("Temperature: " + temp + " degrees");
                            System.out.println("Humidity: " + forecast.getJSONObject("main").getInt("humidity") + "%");
                        } else if (option == 2) {
                            JSONObject wind = forecast.getJSONObject("wind");
                            double speed = wind.getDouble("speed");
                            System.out.println("Wind speed: " + speed + " mph");
                        } else if (option == 3) {
                            double pressure = forecast.getJSONObject("main").getDouble("pressure");
                            System.out.println("Pressure: " + pressure + " hPa");
                        }
                        break;
                    }
                }

                if (!foundData) {
                    System.out.println("No weather data available for the entered date.");
                }

            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        sc.close();
    }

    public static JSONObject readJsonFromUrl(String url) {
        try {
            URL apiURL = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(apiURL.openStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            return new JSONObject(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
