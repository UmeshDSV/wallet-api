package com.assignment.WalletRestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.WalletRestApi.entities.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Long>{

}
