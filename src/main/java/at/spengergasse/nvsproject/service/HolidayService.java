package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.Holiday;
import at.spengergasse.nvsproject.persistence.HolidayClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource(value = "classpath:restclient.yml")
@ConfigurationProperties (prefix = "calendariffic")
public class HolidayService {

    @Value("{apiKey}")
    private String apiKey;
    private final HolidayClient holidayClient;

    public List<Holiday> getAllHolidaysForYear(String countryCode, int year){
        return holidayClient.getAllHolidays(apiKey, countryCode, year)
                .getResponse()
                .getHolidays()
                .stream()
                .map(Holiday::new)
                .collect(Collectors.toList());
    }
}
