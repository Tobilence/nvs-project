package at.spengergasse.nvsproject.service.dto.restmodels;

import lombok.Getter;
import lombok.Setter;

/**
 * Wrapper of the Response
 * Needed in order to exactly match the style of the Calendariffic response
 */
@Getter
@Setter
public class CalendarificResponseWrapper {

    private CalendarificResponse response;
}




