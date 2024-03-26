package com.OxeBank.banking.repository

import com.OxeBank.banking.repository.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
interface UserRepository: JpaRepository<UserEntity, Long>{

}