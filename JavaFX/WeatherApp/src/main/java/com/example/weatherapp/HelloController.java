package com.example.weatherapp;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HelloController {

  @FXML
  private TextField cityTextField;
  @FXML
  private Label cityLabel;
  @FXML
  private Label tempLabel;
  @FXML
  private Label statusLabel;
  @FXML
  private ImageView weatherIcon;

  @FXML
  private void handleSearchAction() {
    String city = cityTextField.getText();
    String apiKey = "0e95c823951bd8898ce62701d0a88dc2";
    String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

    try {
      URL url = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      int responseCode = conn.getResponseCode();
      if (responseCode != 200) {
        throw new RuntimeException("HttpResponseCode: " + responseCode);
      } else {
        StringBuilder inline = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
          inline.append(scanner.nextLine());
        }
        scanner.close();

        JsonObject jsonObject = JsonParser.parseString(inline.toString()).getAsJsonObject();
        String cityName = jsonObject.get("name").getAsString();
        String temp = jsonObject.get("main").getAsJsonObject().get("temp").getAsString();
        String status = jsonObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsString();
        String icon = jsonObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();

        cityLabel.setText(cityName);
        tempLabel.setText(temp + "°C");
        statusLabel.setText(status);
        weatherIcon.setImage(new Image("https://openweathermap.org/img/wn/" + icon + "@2x.png"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
