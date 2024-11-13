package org.shakyground.earthquakebe.earthquake.events.entities;

public record PropertiesDto(String title, String place, double mag, long time, long updated, GeometryDto geometry) {
}
