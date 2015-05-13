package com.rf.beans;
import java.sql.Date;

public class Account implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private String AccountNumber;
	private String AccountId;
	private Integer AccountTypeCode;
	private Integer AccountStatusCode;
	private Integer GenderId;
	private String FirstName;
	private String LastName;
	private String NickName;
	private String LegalName;
	private String CurrencyCode;
	private String CurrencyName;
	private String CountryCode;
	private String DisplayTaxNumber;
	private String TimeZoneCode;
	private String LanguageCode;
	private String LanguageName;
	private String PersonalPhotoUrl;
	private String SponsorId;
	private String SponsorAccountNumber;
	private String SponsorName;
	private String EnrollerId;
	private String EnrollerAccountNumber;
	private String EnrollerName;
	private String UpdateReasonId;
	
	private Date Birthday;
	private Date SoftTerminationDate;
	private Date HardTerminationDate;
	private Date NextRenewalDate;
	private Date LastRenewalDate;
	private Date EnrollmentDate;
	Boolean TaxExempt;
	Boolean Active;
	Boolean BusinessEntity;
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountId() {
		return AccountId;
	}
	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	public Integer getAccountTypeCode() {
		return AccountTypeCode;
	}
	public void setAccountTypeCode(Integer accountTypeCode) {
		AccountTypeCode = accountTypeCode;
	}
	public Integer getAccountStatusCode() {
		return AccountStatusCode;
	}
	public void setAccountStatusCode(Integer accountStatusCode) {
		AccountStatusCode = accountStatusCode;
	}
	public Integer getGenderId() {
		return GenderId;
	}
	public void setGenderId(Integer genderId) {
		GenderId = genderId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getLegalName() {
		return LegalName;
	}
	public void setLegalName(String legalName) {
		LegalName = legalName;
	}
	public String getCurrencyCode() {
		return CurrencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return CurrencyName;
	}
	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDisplayTaxNumber() {
		return DisplayTaxNumber;
	}
	public void setDisplayTaxNumber(String displayTaxNumber) {
		DisplayTaxNumber = displayTaxNumber;
	}
	public String getTimeZoneCode() {
		return TimeZoneCode;
	}
	public void setTimeZoneCode(String timeZoneCode) {
		TimeZoneCode = timeZoneCode;
	}
	public String getLanguageCode() {
		return LanguageCode;
	}
	public void setLanguageCode(String languageCode) {
		LanguageCode = languageCode;
	}
	public String getLanguageName() {
		return LanguageName;
	}
	public void setLanguageName(String languageName) {
		LanguageName = languageName;
	}
	public String getPersonalPhotoUrl() {
		return PersonalPhotoUrl;
	}
	public void setPersonalPhotoUrl(String personalPhotoUrl) {
		PersonalPhotoUrl = personalPhotoUrl;
	}
	public String getSponsorId() {
		return SponsorId;
	}
	public void setSponsorId(String sponsorId) {
		SponsorId = sponsorId;
	}
	public String getSponsorAccountNumber() {
		return SponsorAccountNumber;
	}
	public void setSponsorAccountNumber(String sponsorAccount) {
		SponsorAccountNumber = sponsorAccount;
	}
	public String getSponsorName() {
		return SponsorName;
	}
	public void setSponsorName(String sponsorName) {
		SponsorName = sponsorName;
	}
	public String getEnrollerId() {
		return EnrollerId;
	}
	public void setEnrollerId(String enrollerId) {
		EnrollerId = enrollerId;
	}
	public String getEnrollerAccountNumber() {
		return EnrollerAccountNumber;
	}
	public void setEnrollerAccountNumber(String enrollerAccountNumber) {
		EnrollerAccountNumber = enrollerAccountNumber;
	}
	public String getEnrollerName() {
		return EnrollerName;
	}
	public void setEnrollerName(String enrollerName) {
		EnrollerName = enrollerName;
	}
	public String getUpdateReasonId() {
		return UpdateReasonId;
	}
	public void setUpdateReasonId(String updateReasonId) {
		UpdateReasonId = updateReasonId;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public Date getSoftTerminationDate() {
		return SoftTerminationDate;
	}
	public void setSoftTerminationDate(Date softTerminationDate) {
		SoftTerminationDate = softTerminationDate;
	}
	public Date getHardTerminationDate() {
		return HardTerminationDate;
	}
	public void setHardTerminationDate(Date hardTerminationDate) {
		HardTerminationDate = hardTerminationDate;
	}
	public Date getNextRenewalDate() {
		return NextRenewalDate;
	}
	public void setNextRenewalDate(Date nextRenewalDate) {
		NextRenewalDate = nextRenewalDate;
	}
	public Date getLastRenewalDate() {
		return LastRenewalDate;
	}
	public void setLastRenewalDate(Date lastRenewalDate) {
		LastRenewalDate = lastRenewalDate;
	}
	public Date getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	public Boolean getTaxExempt() {
		return TaxExempt;
	}
	public void setTaxExempt(Boolean taxExempt) {
		TaxExempt = taxExempt;
	}
	public Boolean getActive() {
		return Active;
	}
	public void setActive(Boolean active) {
		Active = active;
	}
	public Boolean getBusinessEntity() {
		return BusinessEntity;
	}
	public void setBusinessEntity(Boolean businessEntity) {
		BusinessEntity = businessEntity;
	}
}