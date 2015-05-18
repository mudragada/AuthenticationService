package com.rf.account.beans;
import java.sql.Date;

public class Account implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private String accountNumber;
	private String id;

	private Integer accountTypeCode;
	private Integer accountStatusCode;
	private Integer genderId;
	private String firstName;
	private String lastName;
	private String nickName;
	private String legalName;
	private String currencyCode;
	private String currencyName;
	private String countryCode;
	private String displayTaxNumber;
	private String timeZoneCode;
	private String languageCode;
	private String languageName;
	private String personalPhotoUrl;
	private String sponsorId;
	private String sponsorAccountNumber;
	private String sponsorName;
	private String enrollerId;
	private String enrollerAccountNumber;
	private String enrollerName;
	private String updateReasonId;
	
	private Date birthday;
	private Date softTerminationDate;
	private Date hardTerminationDate;
	private Date nextRenewalDate;
	private Date lastRenewalDate;
	private Date enrollmentDate;
	Boolean taxExempt;
	Boolean active;
	Boolean businessEntity;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAccountTypeCode() {
		return accountTypeCode;
	}
	public void setAccountTypeCode(Integer accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}
	public Integer getAccountStatusCode() {
		return accountStatusCode;
	}
	public void setAccountStatusCode(Integer accountStatusCode) {
		this.accountStatusCode = accountStatusCode;
	}
	public Integer getGenderId() {
		return genderId;
	}
	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDisplayTaxNumber() {
		return displayTaxNumber;
	}
	public void setDisplayTaxNumber(String displayTaxNumber) {
		this.displayTaxNumber = displayTaxNumber;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getPersonalPhotoUrl() {
		return personalPhotoUrl;
	}
	public void setPersonalPhotoUrl(String personalPhotoUrl) {
		this.personalPhotoUrl = personalPhotoUrl;
	}
	public String getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}
	public String getSponsorAccountNumber() {
		return sponsorAccountNumber;
	}
	public void setSponsorAccountNumber(String sponsorAccountNumber) {
		this.sponsorAccountNumber = sponsorAccountNumber;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public String getEnrollerId() {
		return enrollerId;
	}
	public void setEnrollerId(String enrollerId) {
		this.enrollerId = enrollerId;
	}
	public String getEnrollerAccountNumber() {
		return enrollerAccountNumber;
	}
	public void setEnrollerAccountNumber(String enrollerAccountNumber) {
		this.enrollerAccountNumber = enrollerAccountNumber;
	}
	public String getEnrollerName() {
		return enrollerName;
	}
	public void setEnrollerName(String enrollerName) {
		this.enrollerName = enrollerName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getSoftTerminationDate() {
		return softTerminationDate;
	}
	public void setSoftTerminationDate(Date softTerminationDate) {
		this.softTerminationDate = softTerminationDate;
	}
	public Date getHardTerminationDate() {
		return hardTerminationDate;
	}
	public void setHardTerminationDate(Date hardTerminationDate) {
		this.hardTerminationDate = hardTerminationDate;
	}
	public Date getNextRenewalDate() {
		return nextRenewalDate;
	}
	public void setNextRenewalDate(Date nextRenewalDate) {
		this.nextRenewalDate = nextRenewalDate;
	}
	public Date getLastRenewalDate() {
		return lastRenewalDate;
	}
	public void setLastRenewalDate(Date lastRenewalDate) {
		this.lastRenewalDate = lastRenewalDate;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public Boolean getTaxExempt() {
		return taxExempt;
	}
	public void setTaxExempt(Boolean taxExempt) {
		this.taxExempt = taxExempt;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getBusinessEntity() {
		return businessEntity;
	}
	public void setBusinessEntity(Boolean businessEntity) {
		this.businessEntity = businessEntity;
	}
	public String getTimeZoneCode() {
		return timeZoneCode;
	}
	public void setTimeZoneCode(String timeZoneCode) {
		this.timeZoneCode = timeZoneCode;
	}
	public String getUpdateReasonId() {
		return updateReasonId;
	}
	public void setUpdateReasonId(String updateReasonId) {
		this.updateReasonId = updateReasonId;
	}

}