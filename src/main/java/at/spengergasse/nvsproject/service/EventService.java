package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.persistence.EventRepository;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDto> findAllEvents(){
        return eventRepository
                .findAll()
                .stream()
                .map(EventDto::new)
                .collect(Collectors.toList());
    }
}
