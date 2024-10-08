package com.grigoriank.expenseTracker.entity;

import com.grigoriank.expenseTracker.dto.IncomeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private LocalDate date;
    private Integer amount;

    public IncomeDto getIncomeDto() {
        IncomeDto incomeDto = new IncomeDto();

        incomeDto.setId(id);
        incomeDto.setTitle(title);
        incomeDto.setDescription(description);
        incomeDto.setCategory(category);
        incomeDto.setDate(date);
        incomeDto.setAmount(amount);

        return incomeDto;
    }
}
