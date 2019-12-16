package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.service.dto.restmodels.CalendarificResponseWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Holiday Client
 * This class handles all the HTTP Requests that get sent towards the Calendariffic Api
 */
@FeignClient(url = "https://calendarific.com/api/v2", value = "Calendarific")
public interface HolidayClient {

    /**
     * The basic get Request
     * @param apiKey the token needed for authentication
     * @param countryCode the country code of which the holidays are wanted
     * @param year the year the holidays should be in
     * @return a list of all holidays with the given arguments
     */
    @RequestMapping(method = RequestMethod.GET, value = "/holidays")
    CalendarificResponseWrapper getAllHolidays(@RequestParam(name = "api_key") String apiKey,
                                               @RequestParam(name = "country") String countryCode,
                                               @RequestParam(name = "year") int year);
}
