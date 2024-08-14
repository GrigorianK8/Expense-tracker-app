package com.grigoriank.expenseTracker.service.impl;

import com.grigoriank.expenseTracker.dto.ExpenseDto;
import com.grigoriank.expenseTracker.entity.Expense;
import com.grigoriank.expenseTracker.repository.ExpenseRepository;
import com.grigoriank.expenseTracker.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public Expense postExpense(ExpenseDto expenseDto) {
        return saveOrUpdate(new Expense(), expenseDto);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        }
        throw new EntityNotFoundException("Expense is not present with id: " + id);
    }

    @Override
    public Expense updateExpense(Long id, ExpenseDto expenseDto) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return saveOrUpdate(optionalExpense.get(), expenseDto);
        }
        else {
            throw new EntityNotFoundException("Expense is not present with id: " + id);
        }
    }

    @Override
    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Expense is not present with id: " + id);
        }
    }

    private Expense saveOrUpdate(Expense expense, ExpenseDto expenseDto) {
        expense.setTitle(expenseDto.getTitle());
        expense.setDescription(expenseDto.getDescription());
        expense.setCategory(expenseDto.getCategory());
        expense.setDate(expenseDto.getDate());
        expense.setAmount(expenseDto.getAmount());

        return expenseRepository.save(expense);
    }
}
