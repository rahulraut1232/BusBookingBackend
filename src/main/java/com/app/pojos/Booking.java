package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

//pojo layer class for user booking

@Entity
@Table(name= "bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "dept_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;
	@Column(name = "booking_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBooking;
	@Enumerated(EnumType.STRING)
	private BookingType bookType;
	@OneToOne
	@JoinColumn(name = "boarding_id")
	@JsonIgnore
	private Station boardingStation;
	@OneToOne
	@JoinColumn(name = "dropping_id")
	@JsonIgnore
	private Station droppingStation;
	@Column(unique = true)
	private int seatNumber;
	private double fare;
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
	
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer id, LocalDate dateOfJourney, LocalDate dateOfBooking, BookingType bookType,
			Station boardingStation, Station droppingStation, int seatNumber, double fare, BookingStatus bookingStatus, Bus bus,
			User user, Route route) {
		super();
		this.id = id;
		this.dateOfJourney = dateOfJourney;
		this.dateOfBooking = dateOfBooking;
		this.bookType = bookType;
		this.boardingStation = boardingStation;
		this.droppingStation = droppingStation;
		this.seatNumber = seatNumber;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.bus = bus;
		this.user = user;
		this.route = route;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public BookingType getBookType() {
		return bookType;
	}

	public void setBookType(BookingType bookType) {
		this.bookType = bookType;
	}

	public Station getBoardingStation() {
		return boardingStation;
	}

	public void setBoardingStation(Station boardingStation) {
		this.boardingStation = boardingStation;
	}

	public Station getDroppingStation() {
		return droppingStation;
	}

	public void setDroppingStation(Station droppingStation) {
		this.droppingStation = droppingStation;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", dateOfJourney=" + dateOfJourney + ", dateOfBooking=" + dateOfBooking
				+ ", bookType=" + bookType + ", boardingStation=" + boardingStation + ", droppingStation="
				+ droppingStation + ", seatNumber=" + seatNumber + ", fare=" + fare + ", bookingStatus=" + bookingStatus
				+ "]";
	}
	
}
