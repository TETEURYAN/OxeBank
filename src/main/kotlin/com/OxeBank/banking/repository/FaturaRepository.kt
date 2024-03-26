package com.OxeBank.banking.repository

import com.OxeBank.banking.repository.model.FaturaEntity
import org.springframework.data.jpa.repository.JpaRepository
interface FaturaRepository: JpaRepository<FaturaEntity, Long>{

}