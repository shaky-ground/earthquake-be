package org.shakyground.earthquakebe.earthquake.events;

import lombok.RequiredArgsConstructor;
import org.shakyground.earthquakebe.earthquake.events.entities.EarthquakeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventsResource {
    private final EventsService eventsService;

    @GetMapping(value = "/earthquakes", produces = "application/json;charset=UTF-8")
    public EarthquakeDto getEarthquakeEvents() {
        return eventsService.getEarthquakeEvents();
    }
}
