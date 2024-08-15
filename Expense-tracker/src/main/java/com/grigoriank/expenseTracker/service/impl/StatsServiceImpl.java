package com.grigoriank.expenseTracker.service.impl;

import com.grigoriank.expenseTracker.dto.GraphDto;
import com.grigoriank.expenseTracker.dto.StatsDto;
import com.grigoriank.expenseTracker.entity.Expense;
import com.grigoriank.expenseTracker.entity.Income;
import com.grigoriank.expenseTracker.repository.ExpenseRepository;
import com.grigoriank.expenseTracker.repository.IncomeRepository;
import com.grigoriank.expenseTracker.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    @Override
    public GraphDto getChartData() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDto graphDto = new GraphDto();
        graphDto.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
        graphDto.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));

        return graphDto;
    }

    @Override
    public StatsDto getStats() {
        Double totalExpense = expenseRepository.sumAllAmounts();
        Double totalIncome = incomeRepository.sumAllAmounts();

        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();
        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();

        StatsDto statsDto = new StatsDto();
        statsDto.setExpense(totalExpense);
        statsDto.setIncome(totalIncome);

        optionalExpense.ifPresent(statsDto::setLatestExpense);
        optionalIncome.ifPresent(statsDto::setLatestIncome);

        statsDto.setBalance(totalExpense-totalIncome);

        List<Expense> expenseList = expenseRepository.findAll();
        List<Income> incomeList = incomeRepository.findAll();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        statsDto.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
        statsDto.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);

        statsDto.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
        statsDto.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);

        return statsDto;
    }
}
