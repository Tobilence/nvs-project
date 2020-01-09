package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.Holiday;
import at.spengergasse.nvsproject.persistence.HolidayClient;
import at.spengergasse.nvsproject.service.dto.PreparedHoliday;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Holiday Service
 * This class is responsible for all the logic involving holiday objects
 */
@Service
@RequiredArgsConstructor
public class HolidayService {

    private static final String API_KEY = "da19f4f82a405895592d217690992c84b6ba2d3f";
    private final HolidayClient holidayClient;

    /**
     * Calls the api
     * @param countryCode the countryCode that gets passed to the client
     * @return a list of all Holidays with the given arguments
     */
    public List<PreparedHoliday> getHolidaysForCountryCode(String countryCode){
        return holidayClient.getAllHolidays(API_KEY, countryCode, Year.now().getValue())
                .getResponse()
                .getHolidays()
                .stream()
                .filter((holiday) -> holiday.getType().contains("National holiday"))
                .map(PreparedHoliday::new)
                .collect(Collectors.toList()); //add filter for type (holiday dto)
    }
}
