package edu.escuelaing.weatherAPI.document;

import edu.escuelaing.weatherAPI.data.dto.WeatherDto;

import java.sql.Date;
import java.util.UUID;

public class Weather {
    private String id;
    private String description;
    private double temperature;
    private Date time;
    private String location;

    public Weather(WeatherDto weatherDto) {
        id = UUID.randomUUID().toString();
        description = weatherDto.getDescription();
        temperature = weatherDto.getTemperature();
        time = weatherDto.getTime();
        location = weatherDto.getLocation();
    }
}
