package org.shakyground.earthquakebe.earthquake.events.entities;

import java.util.List;

public record EarthquakeDto(MetaDataDto metadata, List<FeatureDto> features) {
}
