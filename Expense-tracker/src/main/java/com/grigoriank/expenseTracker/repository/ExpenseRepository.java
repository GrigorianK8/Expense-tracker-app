package com.grigoriank.expenseTracker.repository;

import com.grigoriank.expenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
