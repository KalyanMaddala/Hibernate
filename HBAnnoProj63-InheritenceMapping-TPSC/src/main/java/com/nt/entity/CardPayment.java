package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="INH_CARDPAYMENT2")
@PrimaryKeyJoinColumn(name="PAYMENT_ID",referencedColumnName ="TXID" )
public class CardPayment extends Payment {
	@Column(length=16)
	@Type(type="long")
	private long cardNo;
	@Column(length=10)
	@Type(type="string")
	private  String cardType;
	@Column(length=10)
	@Type(type="string")
	private  String cardBankName;
	
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardBankName() {
		return cardBankName;
	}
	public void setCardBankName(String cardBankName) {
		this.cardBankName = cardBankName;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", cardBankName=" + cardBankName
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
