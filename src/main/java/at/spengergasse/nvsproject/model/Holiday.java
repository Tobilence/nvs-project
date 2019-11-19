package at.spengergasse.nvsproject.model;

import at.spengergasse.nvsproject.service.dto.HolidayDto;

import java.time.LocalDate;

public class Holiday {

    private String name;
    private String description;
    private LocalDate date;
    private String type;

    public Holiday(HolidayDto holidayDto){
        this.name = holidayDto.getName();
        this.description = holidayDto.getDescription();
        this.type = holidayDto.getType().get(0);
        this.date = LocalDate.of(holidayDto.getDate().getDatetime().getYear(),
                holidayDto.getDate().getDatetime().getMonth(),
                holidayDto.getDate().getDatetime().getDay());
    }
}
