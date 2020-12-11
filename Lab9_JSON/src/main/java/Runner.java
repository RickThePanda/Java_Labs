import by.gsu.pms.Utils;
import by.gsu.pms.beans.WeatherCard;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        try {
            final String URL =
                    "http://api.openweathermap.org/data/2.5/weather?q=Minsk&appid=98c9b61d85e0e48254cd1b20cd8f067e";
            final URL templatePath = Runner.class.getResource("template.html");

            File file = Utils.writeFromUrl(URL);
            JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file)));
            Gson gson = new Gson();
            WeatherCard card = gson.fromJson(reader, WeatherCard.class);

            final String city = card.getCityName();
            final String code = card.getCode();
            final String icon = card.getIcon();
            final String description = card.getDescription();
            final String fullDescription = card.getFullDescription();
            final String temp = card.getTemp();
            final String pressure = card.getPressure();
            final String humidity = card.getHumidity();
            final String minTemp = card.getMinTemp();
            final String maxTemp = card.getMaxTemp();
            final String windSpeed = card.getWindSpeed();
            final String windDirection = card.getWindDirection();
            final String clouds = card.getClouds();

            final String[] cardFields = new String[] {city, code, description, fullDescription, temp, pressure, humidity, minTemp, maxTemp, windSpeed, windDirection, clouds};
            final String[] cardFieldsAddition = new String[] {
                    "",
                    "",
                    "",
                    "Temperature: ",
                    "Pressure: ",
                    "Humidity: ",
                    "Min temp: ",
                    "Max temp: ",
                    "Wind speed: ",
                    "Wind direction: ",
                    "Clouds: ",
            };
            StringBuilder bld = new StringBuilder();
            bld.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Weather widget</title>\n" +
                    "    <style>\n" +
                    "        @import url(https://fonts.googleapis.com/css?family=Poiret+One);\n" +
                    "\n" +
                    "        body {\n" +
                    "            background-color: #e07a37;\n" +
                    "            font-family: Poiret One,serif;\n" +
                    "            display: flex;\n" +
                    "            align-content: center;\n" +
                    "            justify-content: center;\n" +
                    "            height: 100%;\n" +
                    "            margin: 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        html {\n" +
                    "            height: 100%;\n" +
                    "        }\n" +
                    "\n" +
                    "        .widget {\n" +
                    "            display: flex;\n" +
                    "            justify-self: center;\n" +
                    "            align-self: center;\n" +
                    "            background-color: #fff;\n" +
                    "            border-radius: 120px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .widget_container {\n" +
                    "            display: flex;\n" +
                    "            flex-direction: column;\n" +
                    "            width: 100%;\n" +
                    "            align-content: center;\n" +
                    "            align-items: center;\n" +
                    "            justify-content: center;\n" +
                    "            font-size: 24px;\n" +
                    "            padding: 40px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<article class=\"widget\">\n" +
                    "    <div class=\"widget_container\">" +
                    "<img src=\"http://openweathermap.org/img/w/").append(icon).append(".png\">\n");



            for (int i = 0; i < cardFields.length - 1; i++) {
                bld.append("<div>").append(cardFieldsAddition[i]).append(cardFields[i]).append("</div>");
            }

            bld.append(" </div>\n" +
                    "\n" +
                    "</article>\n" +
                    "</body>\n" +
                    "</html>");
            String htmlString = bld.toString();

            File newHtmlFile = new File("out/widget.html");
            Utils.writeFromFile(newHtmlFile, htmlString);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
