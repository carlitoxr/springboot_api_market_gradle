package com.marketejemplo.market.domain.repository;

import com.marketejemplo.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
        // Retorna una lista de compras de un cliente. Es un purchase porque puede ser null
    Purchase save(Purchase purchase);
}
