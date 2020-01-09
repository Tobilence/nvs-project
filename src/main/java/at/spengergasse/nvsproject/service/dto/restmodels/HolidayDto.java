package at.spengergasse.nvsproject.service.dto.restmodels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The Data Transfer Object for holidays
 * still with the HolidayDate Wrapper instead of Java's LocalDate
 */
@Getter
@Setter
public class HolidayDto {

    private String name;
    private String description;
    private HolidayDate date;
    private List<String> type;
}





