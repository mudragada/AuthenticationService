package rfo.ws.beans;
import java.sql.Date;

public class Account implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer AccountNumber;
	private Integer AccountId;
	private Integer AccountTypeCode;
	private Integer AccountStatusCode;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private Date Birthday;
	private Date SoftTerminationDate;
	private Date HardTerminationDate;
	Boolean TaxExempt;
	Boolean Active;
	Boolean BusinessEntity;
	public Integer getAccountStatusCode() {
		return AccountStatusCode;
	}

	public void setAccountStatusCode(Integer accountStatusCode) {
		AccountStatusCode = accountStatusCode;
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

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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

	public Boolean isTaxExempt() {
		return TaxExempt;
	}

	public void setTaxExempt(Boolean taxExempt) {
		TaxExempt = taxExempt;
	}

	public Boolean isActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}

	public Boolean isBusinessEntity() {
		return BusinessEntity;
	}

	public void setBusinessEntity(Boolean businessEntity) {
		BusinessEntity = businessEntity;
	}
	public Account() {
	}

	public Account(Integer AccountId) {
		this.AccountId = AccountId;
	}

	public Integer getAccountNumber() {
		return this.AccountNumber;
	}

	public void setAccountNumber(Integer AccountNumber) {
		this.AccountNumber = AccountNumber;
	}

	public Integer getAccountId() {
		return this.AccountId;
	}

	public void setAccountId(Integer AccountId) {
		this.AccountId = AccountId;
	}

	public Integer getAccountTypeCode() {
		return this.AccountTypeCode;
	}

	public void setAccountTypeCode(Integer AccountTypeCode) {
		this.AccountTypeCode = AccountTypeCode;
	}
}