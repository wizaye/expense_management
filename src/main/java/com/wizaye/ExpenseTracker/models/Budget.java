package com.wizaye.ExpenseTracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Budget")
public class Budget {
    @Id
    private UUID id= UUID.randomUUID();
    private UUID userId;
    private String category;
    private double monthly_budget;
    private Date start_date;
    private Date end_date;
}
