package com.hino.loyalty.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hino.loyalty.domain.enums.PaymentStatus;

@Entity
public class BoletoPayment extends Payment {
	
		private static final long serialVersionUID = 1L;

		@JsonFormat(pattern="dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Date dueDate;
		
		@JsonFormat(pattern="dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Date paymentDate;
		
		public BoletoPayment() {
			
		}

		public BoletoPayment(Integer id, PaymentStatus status, PurchaseOrder order, Date dueDate, Date paymentDate) {
			super(id, status, order);
			this.dueDate = dueDate;
			this.paymentDate = paymentDate;
			
			// TODO Auto-generated constructor stub
		}

		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}

		public Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}
		
		
		
		
}
