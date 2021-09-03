package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj.seller, SUM(obj.amount) " +
            " FROM Sale AS obj " +
            " GROUP BY obj.seller")
    List<Object[]> amountGroupedBySeller();

    @Query("SELECT obj.seller, SUM(obj.visited), SUM(obj.deals) " +
            " FROM Sale AS obj " +
            " GROUP BY obj.seller")
    List<Object[]> successGroupedBySeller();

}
