package com.grigoriank.expenseTracker.dto;

import com.grigoriank.expenseTracker.entity.Expense;
import com.grigoriank.expenseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDto {

    private Double expense;
    private Double income;

    private Expense latestExpense;
    private Income latestIncome;

    private Double balance;
    private Double minExpense;
    private Double maxExpense;
    private Double minIncome;
    private Double maxIncome;
}
