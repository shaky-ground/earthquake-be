package org.shakyground.earthquakebe.earthquake.events;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.shakyground.earthquakebe.earthquake.events.entities.EarthquakeDto;

public class DataFixture {
    @SneakyThrows
    public static EarthquakeDto readEarthquakeDtoFromFile(String filePath) {
        var basePath = "src/test/resources/";
        var objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(basePath + filePath), EarthquakeDto.class);
    }
}
