package com.me.reactive.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class ProductDto(
    var id: String? = null,
    var name: String? = null,
    var qty: Int? = null,
    var price: Double? = null,
) {}
