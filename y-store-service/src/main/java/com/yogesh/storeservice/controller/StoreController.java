package com.yogesh.storeservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.storeservice.dao.store.CustomerDao;
import com.yogesh.storeservice.dao.store.ProductDao;
import com.yogesh.storeservice.dao.store.PurchaseDao;
import com.yogesh.storeservice.model.store.CPurchaseUI;
import com.yogesh.storeservice.model.store.Customer;
import com.yogesh.storeservice.model.store.Product;
import com.yogesh.storeservice.model.store.Purchase;
import com.yogesh.storeservice.uitils.Constant;

@RestController
public class StoreController {

	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private PurchaseDao purchaseDao;

	@PostMapping(path = "/purchase")
	public String purchaseProduct(HttpServletRequest request, @RequestBody CPurchaseUI cPurchaseUI) {
		try {

			logger.info("All Purchase");
			Customer customer = null;
			Integer cTotalDayPoints = 0;	
			Integer totalPurchasePoint = 0;
			List<Purchase> purchases = new ArrayList<Purchase>();
			Integer custId = cPurchaseUI.getCustomerId();
			List<Integer> productIds = cPurchaseUI.getProducts();

			if (null != custId) {
				customer = this.customerDao.findByCustomerId(custId);
				if (null != customer) {
					cTotalDayPoints = customer.getTotalDayPoints();
				} else {
					return Constant.CUSTOMER_NOT_EXIST;
				}

			}

			if (CollectionUtils.isNotEmpty(productIds)) {
				for (Integer productId : productIds) {
					Product product = this.productDao.findByProductId(productId);
					if (null != product) {
						Purchase purchase = new Purchase();
						purchase.setCustomer(customer);
						purchase.setProduct(product);
						purchases.add(purchase);
						totalPurchasePoint = totalPurchasePoint + product.getProductPoints();
					} else {
						return Constant.NOT_EXISTING_PORDUCT;
					}

				}

			} else {
				return Constant.PRODUCT_NOT_PROVIDED;
			}

			if (totalPurchasePoint < cTotalDayPoints) {
				cTotalDayPoints = cTotalDayPoints - totalPurchasePoint;
			} else {
				return Constant.NOT_HAVE_ENOUGH_POINTS;
			}

			customer.setTotalDayPoints(cTotalDayPoints);
			this.purchaseDao.saveAll(purchases);
			this.customerDao.save(customer);
			return Constant.OK;
		} catch (Exception e) {
			return Constant.FAILED;
		}

	}

}
