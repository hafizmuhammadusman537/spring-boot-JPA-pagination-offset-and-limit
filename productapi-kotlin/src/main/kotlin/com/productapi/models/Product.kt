package com.productapi.models

import javax.persistence.*

@Entity
@Table(name = "product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
    var name: String? = null
    var upc: String? = null
    var price: Float? = null
    var quantity: Int? = null
    var companyId: Int? = null
}