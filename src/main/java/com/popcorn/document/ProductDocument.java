package com.popcorn.document;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(value = "products")
public class ProductDocument {
    @PrimaryKey
    private Long pid;
    private String name;

    @Column(value = "unit_price")
    private BigDecimal unitPrice;
    @Column(value = "in_stock")
    private Long inStock;

    @Column(value = "created_on")
    private LocalDateTime createdOn;
    @Column(value = "updated_on")
    private LocalDateTime updatedOn;
}
