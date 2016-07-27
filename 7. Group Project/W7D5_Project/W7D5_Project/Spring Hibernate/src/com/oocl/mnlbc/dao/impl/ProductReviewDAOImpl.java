package com.oocl.mnlbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.abstr.GenericCRUDImpl;
import com.oocl.mnlbc.dao.inf.ProductReviewDAO;
import com.oocl.mnlbc.model.ProductReview;

/**
 * 
 * @author Lance Jasper Lopez
 * @since 07/27/2016
 * @desc Product Review Implementation
 *
 */

@Repository
@Transactional
public class ProductReviewDAOImpl extends GenericCRUDImpl<ProductReview> implements ProductReviewDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Override
	public List<ProductReview> listReview() {
		List<ProductReview> reviewList = new ArrayList<ProductReview>();
		String sql = "Select review From ProductReview review";
		reviewList = this.entityManager.createQuery(sql, ProductReview.class).getResultList();
		for (ProductReview review : reviewList) {
			logger.info("Product List:" + review);
		}
		return reviewList;
	}

	@Override
	public List<ProductReview> listReviewByProductId(long productId) {
		List<ProductReview> reviewList = new ArrayList<ProductReview>();
		String sql = "Select review From ProductReview review WHERE review.productId = :productId";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter("productId", productId);
		reviewList = query.getResultList();
		for (ProductReview review : reviewList) {
			logger.info("Product List:" + review);
		}
		return reviewList;

	}

	@Override
	public List<ProductReview> listReviewByUserAndProducts(long productId, String userEmail) {
		List<ProductReview> reviewList = new ArrayList<ProductReview>();
		String sql = "Select review From ProductReview review WHERE review.productId = :productId AND review.email = :userEmail";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter("productId", productId);
		query.setParameter("userEmail", userEmail);
		reviewList = query.getResultList();
		for (ProductReview review : reviewList) {
			logger.info("Product List:" + review);
		}
		return reviewList;
	}

}
