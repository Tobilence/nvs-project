package at.spengergasse.nvsproject.service.dto.restmodels;

import lombok.Getter;
import lombok.Setter;

/**
 * Wrapper of the date
 * needed in order to match the Style of the calendariffic response
 */
@Getter
@Setter
public class HolidayDate {

    private String iso;
    private HolidayDatetime datetime;
}





