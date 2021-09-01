package edu.escuelaing.weatherAPI.service;

import edu.escuelaing.weatherAPI.data.dto.WeatherDto;
import edu.escuelaing.weatherAPI.document.Weather;

public interface WeatherService {

    Weather create (Weather weather);
    Weather updateWeatherById (WeatherDto weatherDto);
    boolean deleteWeatherById (String id);
    Weather findById (String id);
}
