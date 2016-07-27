/**
 * 
 */
package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.dao.abstr.GenericCRUD;
import com.oocl.mnlbc.model.ProductReview;

/**
 * @author Lance Jasper Lopez
 *
 */
public interface ProductReviewDAO extends GenericCRUD<ProductReview> {
	public List<ProductReview> listReview();
}
