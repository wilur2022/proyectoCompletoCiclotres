package com.ciclo3.TodoCompleto.Repositories;

import com.ciclo3.TodoCompleto.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTransaction extends JpaRepository<Transaction,Long> {
}
