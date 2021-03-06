package net.cis.dto;

public class ParkingContractOutOfDateDto {
	private long id;
	private String contractCode;
	private String contractNo;
	private String company;
	private String parkingPlace;
	private long cusId;
	private long validFrom;
	private long validTo;
	private int numberOfMonth;
	private long totalAmount;
	private long remainAmount;
	private long paidAmount;
	private long validEnd;
	private long monthlyUnitPrice;

	private String phone2;
	private String fullName;
	private String email;

	public long getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(long remainAmount) {
		this.remainAmount = remainAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getParkingPlace() {
		return parkingPlace;
	}

	public void setParkingPlace(String parkingPlace) {
		this.parkingPlace = parkingPlace;
	}

	public long getCusId() {
		return cusId;
	}

	public void setCusId(long cusId) {
		this.cusId = cusId;
	}

	public long getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(long validFrom) {
		this.validFrom = validFrom;
	}

	public long getValidTo() {
		return validTo;
	}

	public void setValidTo(long validTo) {
		this.validTo = validTo;
	}

	public int getNumberOfMonth() {
		return numberOfMonth;
	}

	public void setNumberOfMonth(int numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}

	public long getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(long validEnd) {
		this.validEnd = validEnd;
	}

	public long getMonthlyUnitPrice() {
		return monthlyUnitPrice;
	}

	public void setMonthlyUnitPrice(long monthlyUnitPrice) {
		this.monthlyUnitPrice = monthlyUnitPrice;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
