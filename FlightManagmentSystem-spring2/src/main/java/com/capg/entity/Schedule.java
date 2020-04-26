package com.capg.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="schedule")
public class Schedule {

	@Id
	private int scheduleId;
	
	@OneToOne
	@JoinColumn(name="source_airport_code",referencedColumnName = "airportCode")
	private Airport sourceAirport;
	
	@OneToOne
	@JoinColumn(name="destination_airport_code",referencedColumnName = "airportCode")
	private Airport destinationAirport;
	
	@Column(name="ArrivalDate")
	private LocalDate arrivalDate;
	
	@Column(name="DepartureDate")
	private LocalDate departureDate;
	
	@Column(name="ArrivalTime")
	private LocalTime arrivalTime;
	
	@Column(name="DepartureTime")
	private LocalTime departureTime;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="sf2",referencedColumnName = "scheduledFlightId")
	private ScheduledFlight scheduledFlight2;
	

	
	

	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDate arrivalDate, LocalDate departureDate) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	

	

	

//	public List<ScheduledFlight> getScheduledFlight2() {
//		return scheduledFlight2;
//	}
//
//	public void setScheduledFlight2(List<ScheduledFlight> scheduledFlight2) {
//		this.scheduledFlight2 = scheduledFlight2;
//	}

//	@Override
//	public String toString() {
//		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destinationAirport="
//				+ destinationAirport + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate
//				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ",  + "]";
//	}

	
	
	


	

	
}
