package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SaleService {

    @Autowired
    private SaleRepository salesRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); // Brings all sellers and JPA stores them in cache
        Page<Sale> result = salesRepository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        List<Object[]> result = salesRepository.amountGroupedBySeller();
        return result.stream().map(x -> new SaleSumDTO((Seller) x[0], (Double) x[1])).collect(Collectors.toList());
    };

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        List<Object[]> result = salesRepository.successGroupedBySeller();
        return result.stream().map(x -> new SaleSuccessDTO((Seller) x[0], (Long) x[1], (Long) x[2])).collect(Collectors.toList());
    };
}
