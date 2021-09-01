package edu.escuelaing.weatherAPI.controller;

import edu.escuelaing.weatherAPI.data.dto.WeatherDto;
import edu.escuelaing.weatherAPI.document.Weather;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")

public class WeatherController {

    @PostMapping
    public Weather createWeather (@RequestBody WeatherDto weatherDto){
        return new Weather (weatherDto);
    }
    @GetMapping("/{id}")
    public Weather findWeatherById (@PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean deleteWeatherById (@PathVariable String id){
        return false;
    }

    @PutMapping("/{id}")
    public Weather updateWeatherById(@RequestBody WeatherDto weatherDto){
        return null;
    }


}
