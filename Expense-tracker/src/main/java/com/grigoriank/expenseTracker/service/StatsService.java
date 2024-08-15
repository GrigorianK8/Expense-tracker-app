package com.grigoriank.expenseTracker.service;

import com.grigoriank.expenseTracker.dto.GraphDto;
import com.grigoriank.expenseTracker.dto.StatsDto;

public interface StatsService {

    GraphDto getChartData();

    StatsDto getStats();
}
