package at.spengergasse.nvsproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HolidayDto {

    private String name;
    private String description;
    private HolidayDate date;
    private List<String> type;
}





