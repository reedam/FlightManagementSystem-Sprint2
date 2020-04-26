package com.capg.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.Dao.FlightDao;
import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;


@Service
public class FlightService 
{
	@Autowired
	private FlightDao flightDao;
	
	public List<ScheduledFlight> viewScheduledFlights(){
		return flightDao.viewScheduledFlights();
	}
	
	public ScheduledFlight viewScheduledFlight(int flightNumber) {
		return flightDao.viewScheduledFlight(flightNumber);
	}
	
	public String scheduleFlight(ScheduledFlight scheduledFlight) {
		return flightDao.scheduleFlight(scheduledFlight);
	}
	
	public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
		return flightDao.modifyScheduledFlight(flight, schedule, flightNumber);
	}
	
	public String deleteScheduledFlight(int flightNumber) {
		return flightDao.deleteScheduledFlight(flightNumber);
	}
	
	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate){
		return flightDao.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
	}
}
