package com.productapi.controller

import com.productapi.models.Product
import com.productapi.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ProductController {

    @Autowired
    var productService: ProductService? = null

    @GetMapping("/products")
    fun getAllProducts(
            @RequestParam(required = false) companyId: Int?,
            @RequestParam(name = "offset") offset: Int,
            @RequestParam(name = "limit") limit: Int,
            @RequestParam(defaultValue = "asc") sort: String?,
            @RequestParam(defaultValue = "id") sortBy: String?): ResponseEntity<List<Product>>? {

        return try {
            val products: List<Product> = productService?.findProducts(companyId, offset, limit, sort, sortBy) as List<Product>
            ResponseEntity(products, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}