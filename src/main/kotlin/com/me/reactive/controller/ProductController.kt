package com.me.reactive.controller

import com.me.reactive.dto.ProductDto
import com.me.reactive.service.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/products")
class ProductController(
    val service: ProductService,
) {

    @GetMapping
    fun getProducts(): Flux<ProductDto> {
        return service.getProducts()
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: String): Mono<ProductDto> {
        return service.getProduct(id)
    }

    @GetMapping("/product-range")
    fun getProductBetweenRange(
        @RequestParam("min") min: Double, @RequestParam("max") max: Double,
    ): Flux<ProductDto> {
        return service.getProductInRange(min, max)
    }

    @PostMapping
    fun saveProduct(@RequestBody productDtoMono: Mono<ProductDto>): Mono<ProductDto> {
        return service.saveProduct(productDtoMono)
    }

    @PutMapping("/update/{id}")
    fun updateProduct(
        @RequestBody productDtoMono: Mono<ProductDto>,
        @PathVariable id: String,
    ): Mono<ProductDto> {
        return service.updateProduct(productDtoMono, id)
    }

    @DeleteMapping( "/delete/{id}")
    fun deleteProduct(@PathVariable id: String): Mono<Void> {
        return service.deleteProduct(id)
    }
}
