package com.me.reactive.service

import com.me.reactive.dto.ProductDto
import com.me.reactive.repository.ProductRepository
import com.me.reactive.utils.AppUtils
import org.springframework.data.domain.Range
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService(
    private val repository: ProductRepository
) {

    fun getProducts(): Flux<ProductDto> {
        return repository
            .findAll()
            .map(AppUtils::entityToDto)
    }

    fun getProduct(id: String): Mono<ProductDto> {
        return repository
            .findById(id)
            .map(AppUtils::entityToDto)
    }

    fun getProductInRange(min: Double, max: Double): Flux<ProductDto> {
        return repository
            .findByPriceBetween(Range.closed(min, max))
    }

    fun saveProduct(productDtoMono: Mono<ProductDto>): Mono<ProductDto> {
        return productDtoMono
            .map(AppUtils::dtoToEntity)
            .flatMap(repository::insert)
            .map(AppUtils::entityToDto)
    }

    fun updateProduct(productDtoMono: Mono<ProductDto>, id: String): Mono<ProductDto> {
        return repository
            .findById(id)
            .flatMap { p -> productDtoMono.map(AppUtils::dtoToEntity) }
            .doOnNext { e -> e.id = id }
            .flatMap(repository::save)
            .map(AppUtils::entityToDto)
    }

    fun deleteProduct(id: String): Mono<Void> {
        return repository
            .deleteById(id)
    }
}
