package org.shakyground.earthquakebe.earthquake.events;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shakyground.earthquakebe.earthquake.events.entities.EarthquakeDto;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import static org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@ExtendWith(MockitoExtension.class)
class EventsServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private RequestHeadersSpec requestHeadersSpec;

    @Mock
    private ResponseSpec responseSpec;

    @InjectMocks
    private EventsService eventsService;

    @BeforeEach
    void setUp() {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void shouldGetEarthquakeEvents() {
        var mockEarthquakeDto = DataFixture.readEarthquakeDtoFromFile("earthquakeDto.json");
        when(responseSpec.bodyToMono(EarthquakeDto.class)).thenReturn(Mono.just(mockEarthquakeDto));

        var result = eventsService.getEarthquakeEvents();

        assertNotNull(result);
        verify(webClient, times(1)).get();
        verify(requestHeadersUriSpec, times(1)).uri(anyString());
        verify(requestHeadersSpec, times(1)).retrieve();
        verify(responseSpec, times(1)).bodyToMono(EarthquakeDto.class);
    }

    @Test
    void shouldGetEarthquakeEventsAndThrowWebClientException() {
        when(responseSpec.bodyToMono(EarthquakeDto.class)).thenReturn(Mono.error(new WebClientResponseException(
                500,
                "Internal Server Error",
                null,
                null,
                null
        )));

        assertThrows(WebClientResponseException.class, () -> eventsService.getEarthquakeEvents());

        verify(webClient, times(1)).get();
        verify(requestHeadersUriSpec, times(1)).uri(anyString());
        verify(requestHeadersSpec, times(1)).retrieve();
        verify(responseSpec, times(1)).bodyToMono(EarthquakeDto.class);
    }
}
