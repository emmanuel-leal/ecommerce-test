package com.emmanuel.test.products.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {
	private String productId;

	private String description;

	private BigDecimal price;

	private String userId;
	
	private String brand;

	private Instant createdAt;

	private Instant updatedAt;
}
