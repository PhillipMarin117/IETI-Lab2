package edu.escuelaing.weatherAPI.document;

import edu.escuelaing.weatherAPI.data.dto.WeatherDto;

import java.util.Date;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
