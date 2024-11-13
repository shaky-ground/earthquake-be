package org.shakyground.earthquakebe.earthquake.events.entities;

import java.util.List;

public record GeometryDto(String point, List<Double> doubles) {
}
