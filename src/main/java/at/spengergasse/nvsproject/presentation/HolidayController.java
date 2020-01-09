package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.HolidayService;
import at.spengergasse.nvsproject.service.dto.PreparedHoliday;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The holiday Controller
 */
@Controller
@RequiredArgsConstructor
@RequestMapping (path = "/holidays")
@CrossOrigin
public class HolidayController {

    private final HolidayService holidayService;

    @GetMapping (path = "/{countryCode}")
    public ResponseEntity<List<PreparedHoliday>> getHolidaysByCountryCode(@PathVariable String countryCode){
        return ResponseEntity.ok(holidayService.getHolidaysForCountryCode(countryCode));
    }
}
