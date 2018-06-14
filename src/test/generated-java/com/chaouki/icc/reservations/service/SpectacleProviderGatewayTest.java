package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Shows;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SpectacleProviderGatewayTest {

    SpectacleProviderGateway spectacleProviderGateway = new SpectacleProviderGatewayImpl();

    @Test
    public void getShows() {
        List<Shows> showsList = spectacleProviderGateway.getShows();
    }
}