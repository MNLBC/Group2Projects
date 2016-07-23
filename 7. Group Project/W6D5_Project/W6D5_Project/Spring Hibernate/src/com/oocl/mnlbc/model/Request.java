package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author SOQUIDA
 * @since 2016-07-22
 */

@Entity
@Table(name="REQUESTS")
public class Request {

	@Id
	@Column(name="REQID")
	@SequenceGenerator(name = "requests_seq", sequenceName = "REQUESTS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "requests_seq", strategy = GenerationType.SEQUENCE)
	private long requestId;
	@Column(name="USEREMAIL")
	private String userEmail;
	@Column(name="REQDATE")
	private String userDate;
	@Column(name="REQSTATUS")
	private String requestStatus;
	
	
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
}
