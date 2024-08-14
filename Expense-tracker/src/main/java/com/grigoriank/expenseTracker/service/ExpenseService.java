package com.grigoriank.expenseTracker.service;

import com.grigoriank.expenseTracker.dto.ExpenseDto;
import com.grigoriank.expenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDto expenseDto);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDto expenseDto);

    void deleteExpense(Long id);
}
