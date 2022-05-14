package com.me.reactive.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
class Product(
    @Id var id: String? = null,
    var name: String? = null,
    var qty: Int? = null,
    var price: Double? = null,
)
