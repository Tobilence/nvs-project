package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.service.dto.restmodels.CalendarificResponseWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalendarificClientTest {

    @Autowired
    private HolidayClient holidayClient;
    @Autowired
    private EventRepository eventRepository;
/*
    @Test
    public void spike(){
        CalendarificResponseWrapper calendarificResponseWrapper = holidayClient.getAllHolidays(
                "da19f4f82a405895592d217690992c84b6ba2d3f",
                "AT",
                2019);
        assertNotNull(calendarificResponseWrapper.getResponse());
    }
 */
}
