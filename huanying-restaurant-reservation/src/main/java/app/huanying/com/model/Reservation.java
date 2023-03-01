package app.huanying.com.model;

import java.io.Serializable;
import java.time.LocalTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = MyGenerator.GENERATOR_NAME)
	@GenericGenerator(name = MyGenerator.GENERATOR_NAME, strategy = "app.huanying.com.model.MyGenerator")
	private String reservationId;

	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private int numOfSeats;

	@Column
	@NotNull
	private String email;

	@Column
	@NotNull
	private String phoneNo;
	
	@Column
	private LocalTime reservationTime;

	@Column
	private boolean hasOrdered;

	@Column
	private boolean hasCheckedIn;

	@Column
	private boolean hasCancelled;

	public Reservation() {
	}

	public Reservation(String reservation_id, @NotNull String name, @NotNull int numOfSeats, @NotNull String email,
			@NotNull String phoneNo,LocalTime reservationTime, boolean hasOrdered, boolean hasCheckedIn, boolean hasCancelled) {
		super();
		this.reservationId = reservation_id;
		this.name = name;
		this.numOfSeats = numOfSeats;
		this.email = email;
		this.phoneNo = phoneNo;
		this.reservationTime = reservationTime;
		this.hasOrdered = hasOrdered;
		this.hasCheckedIn = hasCheckedIn;
		this.hasCancelled = hasCancelled;
	}

	public String getReservation_id() {
		return reservationId;
	}

	public void setReservation_id(String reservation_id) {
		this.reservationId = reservation_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalTime getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}

	public boolean isHasOrdered() {
		return hasOrdered;
	}

	public void setHasOrdered(boolean hasOrdered) {
		this.hasOrdered = hasOrdered;
	}

	public boolean isHasCheckedIn() {
		return hasCheckedIn;
	}

	public void setHasCheckedIn(boolean hasCheckedIn) {
		this.hasCheckedIn = hasCheckedIn;
	}

	public boolean isHasCancelled() {
		return hasCancelled;
	}

	public void setHasCancelled(boolean hasCancelled) {
		this.hasCancelled = hasCancelled;
	}

	@Override
	public String toString() {
		return String.format(
				"Reservation [reservation_id=%s, name=%s, numOfSeats=%s, email=%s, phoneNo=%s, reservationTime=%s, hasOrdered=%s, hasCheckedIn=%s, tableNumber=%s, hasCancelled=%s]",
				reservationId, name, numOfSeats, email, phoneNo, reservationTime, hasOrdered, hasCheckedIn, hasCancelled);
	}

}
