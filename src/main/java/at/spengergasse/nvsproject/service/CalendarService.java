package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.persistence.CalendarRepository;
import at.spengergasse.nvsproject.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;
}
