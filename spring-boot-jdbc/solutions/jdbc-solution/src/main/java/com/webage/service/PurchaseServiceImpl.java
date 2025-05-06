package com.webage.service;

import com.webage.dao.PurchaseDao;
import com.webage.domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private final PurchaseDao purchaseDAO;

	public PurchaseServiceImpl(PurchaseDao purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}

	public void savePurchase(Purchase purchase) {
		purchaseDAO.savePurchase(purchase);
	}


	public Collection<Purchase> findAllPurchases() {
		return purchaseDAO.getAllPurchases();
	}


	public Purchase findPurchaseById(int id) {
		return purchaseDAO.getPurchase(id);
	}

}
