package at.spengergasse.nvsproject.service.dto.restmodels;

import lombok.Getter;
import lombok.Setter;

/**
 * The Date parameters of every holiday in the calendariffic api
 */
@Getter
@Setter
public class HolidayDatetime {

    private int year;
    private int month;
    private int day;
}


