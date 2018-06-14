package com.chaouki.icc.reservations.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
description here: https://developer.londontheatredirect.com/documentation/general/data-types/complex-1#EventInfo
 */
@JsonIgnoreProperties({ "Images", "MultimediaContent" })
public class EventInfo {

    private int EventId;
    private int EventType;
    private String Name;
    private String Description;
    private int VenueId;
    private String RunningTime;
    private String MinimumAge;
    private String ImportantNotice;
    private String MainImageUrl;
    private String SmallImageUrl;
    private String SpecialGraphics;
    private String ShortOfferText;
    private String LongOfferText;
    private BigDecimal CurrentPrice;
    private BigDecimal OfferPrice;
    private LocalDateTime StartDate;
    private LocalDateTime EndDate;
    private BigDecimal EventMinimumPrice;
//    private List<Image> Images;
//    private List<EventMultimediaContent> MultimediaContent;
    private String EventDetailUrl;
    private String TagLine;
    private boolean PrintAtHomeTicketsEnabled;

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int eventType) {
        EventType = eventType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getVenueId() {
        return VenueId;
    }

    public void setVenueId(int venueId) {
        VenueId = venueId;
    }

    public String getRunningTime() {
        return RunningTime;
    }

    public void setRunningTime(String runningTime) {
        RunningTime = runningTime;
    }

    public String getMinimumAge() {
        return MinimumAge;
    }

    public void setMinimumAge(String minimumAge) {
        MinimumAge = minimumAge;
    }

    public String getImportantNotice() {
        return ImportantNotice;
    }

    public void setImportantNotice(String importantNotice) {
        ImportantNotice = importantNotice;
    }

    public String getMainImageUrl() {
        return MainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        MainImageUrl = mainImageUrl;
    }

    public String getSmallImageUrl() {
        return SmallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        SmallImageUrl = smallImageUrl;
    }

    public String getSpecialGraphics() {
        return SpecialGraphics;
    }

    public void setSpecialGraphics(String specialGraphics) {
        SpecialGraphics = specialGraphics;
    }

    public String getShortOfferText() {
        return ShortOfferText;
    }

    public void setShortOfferText(String shortOfferText) {
        ShortOfferText = shortOfferText;
    }

    public String getLongOfferText() {
        return LongOfferText;
    }

    public void setLongOfferText(String longOfferText) {
        LongOfferText = longOfferText;
    }

    public BigDecimal getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        CurrentPrice = currentPrice;
    }

    public BigDecimal getOfferPrice() {
        return OfferPrice;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        OfferPrice = offerPrice;
    }

    public LocalDateTime getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        StartDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        EndDate = endDate;
    }

    public BigDecimal getEventMinimumPrice() {
        return EventMinimumPrice;
    }

    public void setEventMinimumPrice(BigDecimal eventMinimumPrice) {
        EventMinimumPrice = eventMinimumPrice;
    }

    public String getEventDetailUrl() {
        return EventDetailUrl;
    }

    public void setEventDetailUrl(String eventDetailUrl) {
        EventDetailUrl = eventDetailUrl;
    }

    public String getTagLine() {
        return TagLine;
    }

    public void setTagLine(String tagLine) {
        TagLine = tagLine;
    }

    public boolean isPrintAtHomeTicketsEnabled() {
        return PrintAtHomeTicketsEnabled;
    }

    public void setPrintAtHomeTicketsEnabled(boolean printAtHomeTicketsEnabled) {
        PrintAtHomeTicketsEnabled = printAtHomeTicketsEnabled;
    }
}
