package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.ProductReview;
import com.oocl.mnlbc.svc.inf.ProductReviewSVC;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc Product Review Controller
 * @date 07-27-2016
 * 
 */

@RestController
public class ProductReviewController {

	private ProductReviewSVC reviewSVC;

	@Autowired(required = true)
	@Qualifier(value = "productReviewService")
	public void setProdService(ProductReviewSVC reviewSVC) {
		this.reviewSVC = reviewSVC;
	}

	@RequestMapping(value = "/getProductReview", method = RequestMethod.POST)
	public @ResponseBody List<ProductReview> getAllReview() {
		return this.reviewSVC.getReviews();
	}

	@RequestMapping(value = "/getProductReviewByProduct", method = RequestMethod.POST)
	public @ResponseBody List<ProductReview> getAllReviewByProduct(@RequestParam long productId) {
		return this.reviewSVC.getReviewsByProduct(productId);
	}

	@RequestMapping(value = "/getProductReviewByUserProduct", method = RequestMethod.POST)
	public @ResponseBody List<ProductReview> getAllReviewByUserProduct(@RequestParam long productId,
			@RequestParam String userEmail) {
		return this.reviewSVC.getReviewsByUserProduct(productId, userEmail);
	}

	@RequestMapping(value = "/addProductReview", method = RequestMethod.POST)
	public boolean addReview(@RequestBody ProductReview review) {

		return this.reviewSVC.addReview(review);
	}

	@RequestMapping(value = "/updateProductReview", method = RequestMethod.POST)
	public boolean updateReview(@RequestBody ProductReview review) {
		return this.reviewSVC.updateReview(review);
	}

	@RequestMapping(value = "/removeProductReview", method = RequestMethod.POST)
	public boolean removeReview(@RequestParam long id) {
		return this.reviewSVC.removeReview(id);
	}

}
