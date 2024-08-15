package com.grigoriank.expenseTracker.dto;

import com.grigoriank.expenseTracker.entity.Expense;
import com.grigoriank.expenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDto {

    private List<Expense> expenseList;

    private List<Income> incomeList;
}
