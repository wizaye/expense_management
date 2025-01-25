package com.wizaye.ExpenseTracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class User {
    @Id
    private UUID id=UUID.randomUUID();
    private String username;
    private String password;
    private String email;
    private List<UUID> user_income=new ArrayList<>();
    private List<UUID> user_expenses=new ArrayList<>();
    private List<UUID> user_budget=new ArrayList<>();
}
