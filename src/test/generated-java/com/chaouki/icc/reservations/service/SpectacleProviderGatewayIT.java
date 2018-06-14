package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Shows;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SpectacleProviderGatewayIT {

    SpectacleProviderGateway spectacleProviderGateway = new SpectacleProviderGatewayImpl();

    @Test
    public void getShows() {
        List<Shows> showsList = spectacleProviderGateway.getShows();
        Assert.assertThat(showsList.isEmpty(), is(false));
    }
}