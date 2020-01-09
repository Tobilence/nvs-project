package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.service.dto.restmodels.HolidayDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
public class PreparedHoliday {

    private String name;
    private String details;
    private String start;

    public PreparedHoliday(HolidayDto holidayDto) {
        this.name = holidayDto.getName();
        this.details = Optional.ofNullable(holidayDto.getDescription())
                            .orElse("");
        this.start = LocalDate.of(holidayDto.getDate().getDatetime().getYear(),
                holidayDto.getDate().getDatetime().getMonth(),
                holidayDto.getDate().getDatetime().getDay())
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
