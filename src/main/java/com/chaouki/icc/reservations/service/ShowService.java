package com.chaouki.icc.reservations.service;

import com.chaouki.icc.reservations.domain.Shows;

import java.util.List;

public interface ShowService {

    Integer importShows(List<Shows> showsList);
}
