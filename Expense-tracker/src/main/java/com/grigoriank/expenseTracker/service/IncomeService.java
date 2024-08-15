package com.grigoriank.expenseTracker.service;

import com.grigoriank.expenseTracker.dto.IncomeDto;
import com.grigoriank.expenseTracker.entity.Income;

import java.util.List;

public interface IncomeService {

    Income postIncome(IncomeDto incomeDto);

    List<IncomeDto> getAllIncomes();

    Income uodateIncome(Long id, IncomeDto incomeDto);

    IncomeDto getIncomeById(Long id);

    void deleteIncome(Long id);
}
