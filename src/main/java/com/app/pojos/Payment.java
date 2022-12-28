package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//pojo layer class for user payment

@Entity
@Table(name= "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime transactionDate;
	private double fareAmount;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, LocalDateTime transactionDate, double fareAmount, PaymentStatus status,
			PaymentMethod paymentMethod, User user, Booking booking) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.fareAmount = fareAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.user = user;
		this.booking = booking;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getFareAmount() {
		return fareAmount;
	}

	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}

	public PaymentStatus isStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", transactionDate=" + transactionDate + ", fareAmount=" + fareAmount + ", status="
				+ status + ", paymentMethod=" + paymentMethod + "]";
	}
	
}
