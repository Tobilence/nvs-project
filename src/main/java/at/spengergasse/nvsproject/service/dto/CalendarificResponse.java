package at.spengergasse.nvsproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendarificResponse {

    public List<HolidayDto> holidays;
}


