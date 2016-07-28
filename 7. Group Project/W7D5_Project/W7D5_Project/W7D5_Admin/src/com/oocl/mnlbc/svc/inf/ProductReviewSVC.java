package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.ProductReview;

public interface ProductReviewSVC {

	public List<ProductReview> getReviews();
	
	public List<ProductReview> getReviewsByProduct(long productId);
	
	public List<ProductReview> getReviewsByUserProduct(long productId, String userEmail);
	
	public boolean addReview(ProductReview review);
	
	public boolean updateReview(ProductReview review);
	
	public boolean removeReview(long id);
}
