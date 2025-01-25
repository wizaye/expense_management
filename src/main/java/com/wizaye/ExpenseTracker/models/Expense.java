package com.wizaye.ExpenseTracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Expense")
public class Expense {
    @Id
    private UUID id =UUID.randomUUID();
    private UUID userId;
    private String title;
    private Double amount;
    private String category;
    private String description;
    private String paymentMethod;
}