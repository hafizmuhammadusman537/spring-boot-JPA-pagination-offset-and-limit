package com.productapi.repo

import com.productapi.models.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product?, Long?> {

    fun findByCompanyId(companyId: Int?, pageable: Pageable?): Page<Product?>?

}