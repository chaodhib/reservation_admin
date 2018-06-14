package com.chaouki.icc.reservations.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventDTO {

    @JsonProperty("Events")
    private List<EventInfo> Events;

    public List<EventInfo> getEvents() {
        return Events;
    }

    public void setEvents(List<EventInfo> events) {
        Events = events;
    }
}
