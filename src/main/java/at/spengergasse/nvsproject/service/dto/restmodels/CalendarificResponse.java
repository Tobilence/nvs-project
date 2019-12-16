package at.spengergasse.nvsproject.service.dto.restmodels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The Array that contains all the holidays
 */
@Getter
@Setter
public class CalendarificResponse {

    public List<HolidayDto> holidays;
}


