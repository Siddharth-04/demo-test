package com.bridgelabz.StockPortfolio.repository;

import com.bridgelabz.StockPortfolio.models.Holding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRepository extends JpaRepository<Holding,Long> {
}
