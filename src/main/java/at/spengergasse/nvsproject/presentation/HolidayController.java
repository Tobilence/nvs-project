package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.dto.restmodels.HolidayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The holiday Controller
 */
@Controller
@RequiredArgsConstructor
@RequestMapping (path = "/holidays")
@CrossOrigin
public class HolidayController {


}
