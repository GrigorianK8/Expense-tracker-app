package com.grigoriank.expenseTracker.service.impl;

import com.grigoriank.expenseTracker.dto.IncomeDto;
import com.grigoriank.expenseTracker.entity.Income;
import com.grigoriank.expenseTracker.repository.IncomeRepository;
import com.grigoriank.expenseTracker.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    @Override
    public Income postIncome(IncomeDto incomeDto) {
        return saveOrUpdateIncome(new Income(), incomeDto);
    }

    @Override
    public List<IncomeDto> getAllIncomes() {
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Income uodateIncome(Long id, IncomeDto incomeDto) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            return saveOrUpdateIncome(optionalIncome.get(), incomeDto);
        } else {
            throw new EntityNotFoundException("Income is not present with id: " + id);
        }
    }

    @Override
    public IncomeDto getIncomeById(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            return optionalIncome.get().getIncomeDto();
        } else {
            throw new EntityNotFoundException("Income is not present with id: " + id);
        }
    }

    @Override
    public void deleteIncome(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            incomeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Income is not present with id: " + id);
        }
    }

    private Income saveOrUpdateIncome(Income income, IncomeDto incomeDto) {
        income.setTitle(incomeDto.getTitle());
        income.setDescription(incomeDto.getDescription());
        income.setCategory(incomeDto.getCategory());
        income.setDate(incomeDto.getDate());
        income.setAmount(incomeDto.getAmount());

        return incomeRepository.save(income);
    }
}
