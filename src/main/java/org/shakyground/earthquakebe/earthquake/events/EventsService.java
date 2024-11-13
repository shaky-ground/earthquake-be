package org.shakyground.earthquakebe.earthquake.events;

import lombok.RequiredArgsConstructor;
import org.shakyground.earthquakebe.earthquake.events.entities.EarthquakeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final WebClient webClient;

    public EarthquakeDto getEarthquakeEvents() {
        return webClient.get()
                        .uri(buildEventUri())
                        .retrieve()
                        .bodyToMono(EarthquakeDto.class)
                        .block();
    }

    private String buildEventUri() {
        var now = now();
        var yesterday = now.minusDays(1);

        return String.format("/event/1/query?format=geojson&endtime=%s&starttime=%s",
                             now.format(BASIC_ISO_DATE), yesterday.format(BASIC_ISO_DATE)
        );
    }
}
