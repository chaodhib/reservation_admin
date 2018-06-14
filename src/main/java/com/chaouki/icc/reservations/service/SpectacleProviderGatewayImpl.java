package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Locality;
import com.chaouki.icc.reservations.domain.Locations;
import com.chaouki.icc.reservations.domain.Shows;
import com.chaouki.icc.reservations.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
@Named("spectacleProviderGatewayImpl")
public class SpectacleProviderGatewayImpl implements SpectacleProviderGateway {

    private static final Logger log = LoggerFactory.getLogger(SpectacleProviderGatewayImpl.class);

    private final static String API_KEY = "m7cx2unmh7mczhfb5xeajuys";
    private final static String EVENTS_ENDPOINT = "https://api-sandbox.londontheatredirect.com/rest/v2/Events";
    private final static String VENUE_ENDPOINT = "https://api-sandbox.londontheatredirect.com/rest/v2/Venues";

    private RestTemplate restTemplate = getRestTemplate();

    /*
    in London Theatre Direct API terminology:
    an event is what we call a show (FR: un spectacle).
    a performance is what we call a representation (show + location + datetime) (FR: une representation).
     */
    @Override
    public List<Shows> getShows() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Api-Key", API_KEY);

        Map<Integer, VenueInfo> venueInfoMap = getVenueInfo();

        ResponseEntity<EventDTO> exchange = restTemplate.exchange(EVENTS_ENDPOINT, HttpMethod.GET, new HttpEntity(headers), EventDTO.class);
        return mapToShow(exchange.getBody(), venueInfoMap);
    }

    private Map<Integer, VenueInfo> getVenueInfo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Api-Key", API_KEY);
        ResponseEntity<VenuesDTO> exchange = restTemplate.exchange(VENUE_ENDPOINT, HttpMethod.GET, new HttpEntity(headers), VenuesDTO.class);

        return Arrays.stream(exchange.getBody().Venues).collect(Collectors.toMap(o -> o.VenueId, o -> o));
    }

    private List<Shows> mapToShow(EventDTO eventDTO, Map<Integer, VenueInfo> venueInfoMap) {
        ArrayList<Shows> showsList = new ArrayList<>();
        for (EventInfo eventInfo : eventDTO.getEvents()) {
            Shows shows = new Shows();
            shows.setTitle(eventInfo.getName());
            shows.setLocation(mapLocation(venueInfoMap.get(eventInfo.getVenueId())));
            shows.setSlug(Integer.toString(eventInfo.getEventId()));
            shows.setBookable(true);
            shows.setPosterUrl(StringUtils.isNotBlank(eventInfo.getMainImageUrl()) ? eventInfo.getMainImageUrl() : "http://localhost");
            shows.setPrice(eventInfo.getCurrentPrice().doubleValue());

            showsList.add(shows);
        }
        return showsList;
    }

    private Locations mapLocation(VenueInfo venueInfo) {
        Locations locations = new Locations();

        Locality locality = new Locality();
        String postalCode = StringUtils.isNotBlank(venueInfo.Postcode) ? venueInfo.Postcode : "UNK";
        locality.setPostalCode(postalCode);
        locality.setLocality2(StringUtils.isNotBlank(venueInfo.City) && StringUtils.isNotBlank(venueInfo.Postcode) ? venueInfo.City + " " + postalCode : "Not mentioned"); // we only have the city from this API. not the locality. we could infer the locality from the postalCode but I haven't done it yet.
        locations.setLocality(locality);

        locations.setAddress(StringUtils.isNotBlank(venueInfo.Address) ? venueInfo.Address : "Not mentioned");
        locations.setDesignation(StringUtils.isNotBlank(venueInfo.Name) ? venueInfo.Name : "Not mentioned");
        locations.setPhone(StringUtils.isNotBlank(venueInfo.Telephone) ? StringUtils.left(venueInfo.Telephone, 30) : "Not mentioned");
        locations.setSlug(Integer.toString(venueInfo.VenueId));
        locations.setWebsite("https//localhost");

        return locations;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 20_000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }

    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());;
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter(objectMapper)));
        return restTemplate;
    }
}
