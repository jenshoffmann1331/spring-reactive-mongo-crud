package com.me.reactive.utils

import com.me.reactive.dto.ProductDto
import com.me.reactive.entity.Product
import org.springframework.beans.BeanUtils

object AppUtils {

    fun entityToDto(product: Product): ProductDto {
        var productDto = ProductDto()
        BeanUtils.copyProperties(product, productDto)
        return productDto
    }

    fun dtoToEntity(productDto: ProductDto): Product {
        var product = Product()
        BeanUtils.copyProperties(productDto, product)
        return product
    }
}
