package com.productapi.services

import com.productapi.models.Product
import com.productapi.repo.ProductRepository
import com.productapi.utils.OffsetBasedPageRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    var productRepository: ProductRepository? = null

    fun findProducts(companyId: Int?, offset: Int, limit: Int, sort: String?, sortBy: String?): List<Product?> {
        return try {
            val order = Sort.Order(Sort.Direction.fromString(sort!!), sortBy!!)

            val pageable: Pageable = OffsetBasedPageRequest(offset.toLong(), limit, Sort.by(order))

            // if companyId is null findAll method is called otherwise findByCompanyId
            val pageTuts: Page<Product?>? = if (companyId == null) productRepository!!.findAll(pageable) else productRepository!!.findByCompanyId(companyId, pageable)
            pageTuts!!.content
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}