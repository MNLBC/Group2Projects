/**
 * 
 */
package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Danna Soquiat
 * @since 2016-07-21
 */
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "userId")
	@SequenceGenerator(name = "user_seq", sequenceName = "USERS_SEQ4", allocationSize = 1)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	private long userId;
	private String userFname;
	private String userLname;
	private String userEmail;
	private String userAddress1;
	private String userAddress2;
	private String userSp;
	private int userLevel;
	private String userOccupation;
	private String userCity;
	private String userCountry;
	private String userPass;
	private String userType;

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userFname
	 */
	public String getUserFname() {
		return userFname;
	}

	/**
	 * @param userFname
	 *            the userFname to set
	 */
	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	/**
	 * @return the userLname
	 */
	public String getUserLname() {
		return userLname;
	}

	/**
	 * @param userLname
	 *            the userLname to set
	 */
	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userAddress1
	 */
	public String getUserAddress1() {
		return userAddress1;
	}

	/**
	 * @param userAddress1
	 *            the userAddress1 to set
	 */
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	/**
	 * @return the userAddress2
	 */
	public String getUserAddress2() {
		return userAddress2;
	}

	/**
	 * @param userAddress2
	 *            the userAddress2 to set
	 */
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	/**
	 * @return the userSp
	 */
	public String getUserSp() {
		return userSp;
	}

	/**
	 * @param userSp
	 *            the userSp to set
	 */
	public void setUserSp(String userSp) {
		this.userSp = userSp;
	}

	/**
	 * @return the userLevel
	 */
	public int getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel
	 *            the userLevel to set
	 */
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @return the userOccupation
	 */
	public String getUserOccupation() {
		return userOccupation;
	}

	/**
	 * @param userOccupation
	 *            the userOccupation to set
	 */
	public void setUserOccupation(String userOccupation) {
		this.userOccupation = userOccupation;
	}

	/**
	 * @return the userCity
	 */
	public String getUserCity() {
		return userCity;
	}

	/**
	 * @param userCity
	 *            the userCity to set
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/**
	 * @return the userCountry
	 */
	public String getUserCountry() {
		return userCountry;
	}

	/**
	 * @param userCountry
	 *            the userCountry to set
	 */
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	/**
	 * @return the userPass
	 */
	public String getUserPass() {
		return userPass;
	}

	/**
	 * @param userPass
	 *            the userPass to set
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User(long userId, String userFname, String userLname, String userEmail, String userAddress1,
			String userAddress2, String userSp, int userLevel, String userOccupation, String userCity,
			String userCountry, String userPass, String userType) {
		super();
		this.userId = userId;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userEmail = userEmail;
		this.userAddress1 = userAddress1;
		this.userAddress2 = userAddress2;
		this.userSp = userSp;
		this.userLevel = userLevel;
		this.userOccupation = userOccupation;
		this.userCity = userCity;
		this.userCountry = userCountry;
		this.userPass = userPass;
		this.userType = userType;
	}

	public User() {

	}
}