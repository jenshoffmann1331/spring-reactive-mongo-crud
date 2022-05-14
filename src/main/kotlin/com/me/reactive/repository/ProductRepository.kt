package com.me.reactive.repository

import com.me.reactive.dto.ProductDto
import com.me.reactive.entity.Product
import org.springframework.data.domain.Range
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.DoubleSummaryStatistics

@Repository
interface ProductRepository : ReactiveMongoRepository<Product, String> {
    fun findByPriceBetween(priceRange: Range<Double>): Flux<ProductDto>
}
