package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Lance Jasper C. Lopez
 * @since 07-27-2016
 * @desc ProductReviewModel
 * 
 */
@Entity
@Table(name = "PRODUCTREVIEW")
public class ProductReview {

	@Id
	@Column(name = "PRODREVIEWID")
	@SequenceGenerator(name = "review_seq", sequenceName = "PRODUCTREVIEW_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.SEQUENCE)
	private long reviewId;
	@Column(name = "PRODID")
	private long productId;
	@Column(name = "USEREMAIL")
	private String email;
	@Column(name = "PRODREVIEW")
	private String review;
	@Column(name = "PRODRATING")
	private int rating;
	@Column(name = "PRODREVIEWDATE")
	private String date;

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * @return the reviewId
	 */
	public long getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId
	 *            the reviewId to set
	 */
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
