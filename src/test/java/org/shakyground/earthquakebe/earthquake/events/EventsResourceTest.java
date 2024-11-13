package org.shakyground.earthquakebe.earthquake.events;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventsResourceTest {

    @Mock
    private EventsService eventsService;

    @InjectMocks
    private EventsResource sut;

    @Test
    void shouldEarthquakeEvents() {
        var earthquakeDto = DataFixture.readEarthquakeDtoFromFile("earthquakeDto.json");
        when(eventsService.getEarthquakeEvents()).thenReturn(earthquakeDto);

        var res = sut.getEarthquakeEvents();

        assertThat(res).isEqualTo(earthquakeDto);
    }
}
