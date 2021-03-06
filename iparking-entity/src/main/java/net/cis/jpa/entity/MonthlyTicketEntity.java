package net.cis.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vincent on 02/10/2018
 */
@Entity
@Table(name = "monthly_ticket_view")
public class MonthlyTicketEntity {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="contract_code")
	private String contractCode;

	@Column(name="contract_no")
	private String contractNo;
	
	@Column(name="number_plate")
	private String numberPlate;
	
	@Column(name="company")
	private String company;
	
	@Column(name="parking_place")
	private String parkingPlace;
	
	@Column(name="valid_from")
	private long validFrom;
	
	@Column(name="valid_to")
	private long validTo;
	
	@Column(name="number_of_month")
	private int numberOfMonth;
	
	@Column(name="total_amount")
	private long totalAmount;
	
	@Column(name="paid_amount")
	private long paidAmount;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="valid_end")
	private long validEnd;
	
	@Column(name="metadata")
	private String metadata;
	
	@Column(name="monthly_unit_price")
	private long monthlyUnitPrice;

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

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public long getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(long validEnd) {
		this.validEnd = validEnd;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public long getMonthlyUnitPrice() {
		return monthlyUnitPrice;
	}

	public void setMonthlyUnitPrice(long monthlyUnitPrice) {
		this.monthlyUnitPrice = monthlyUnitPrice;
	}
	
	
	
	
}
