package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.service.dto.CalendarificResponse;
import at.spengergasse.nvsproject.service.dto.CalendarificResponseWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://calendarific.com/api/v2", value = "Calendarific")
public interface HolidayClient {

    @RequestMapping(method = RequestMethod.GET, value = "/holidays")
    CalendarificResponseWrapper getAllHolidays(@RequestParam(name = "api_key") String apiKey,
                                               @RequestParam(name = "country") String countryCode,
                                               @RequestParam(name = "year") int year);
}
