package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.ProductReviewDAO;
import com.oocl.mnlbc.model.ProductReview;
import com.oocl.mnlbc.svc.inf.ProductReviewSVC;


/**
 * 
 * @author Lance Jasper Lopez
 * @desc SVC Implementation for PRODUCTREVIEW TABLE
 * @date 07-27-2016
 * 
 */

@Service
@Transactional
public class ProductReviewSVCImpl implements ProductReviewSVC {

	private ProductReviewDAO productReviewDAO;

	/**
	 * @param prodRevDao
	 *            the prodRevDao to set
	 */
	public void setProductReviewDAO(ProductReviewDAO productReviewDAO) {
		this.productReviewDAO = productReviewDAO;
	}

	@Override
	public List<ProductReview> getReviews() {

		return this.productReviewDAO.listReview();
	}

	@Override
	public boolean addReview(ProductReview review) {

		return this.productReviewDAO.add(review);
	}

	@Override
	public boolean updateReview(ProductReview review) {

		return this.productReviewDAO.update(review);
	}

	@Override
	public boolean removeReview(long id) {
	
		return this.productReviewDAO.remove(id);
	}

}
