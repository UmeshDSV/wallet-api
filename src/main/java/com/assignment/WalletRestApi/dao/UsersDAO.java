package com.assignment.WalletRestApi.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.WalletRestApi.entities.Users;

public interface UsersDAO extends JpaRepository<Users, Long> {

}
