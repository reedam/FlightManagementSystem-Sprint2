package com.capg.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.Service.FlightService;
import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;


@Component
@RestController
public class FlightController 
{
	@Autowired
	FlightService flightService;
	
	@GetMapping("/scheduledFlight")
	public List<ScheduledFlight> viewScheduledFlights(){
		return flightService.viewScheduledFlights();
	}
	
	@GetMapping(value="/scheduledFlight/{flightNumber}",produces= {"application/json"})
	public ScheduledFlight viewScheduledFlight(@PathVariable int flightNumber) {
		return flightService.viewScheduledFlight(flightNumber);
	}
	
	@PostMapping(value="/scheduledFlight/add",produces= {"application/json"})
	public String scheduleFlight(@RequestBody ScheduledFlight scheduledFlight) {
		return flightService.scheduleFlight(scheduledFlight);
	}
	
	@PutMapping(value="/scheduledFlight/modify",consumes= {"application/json"})
	public String modifyScheduledFlight(@RequestBody Flight flight,Schedule schedule,int flightNumber) {
		return flightService.modifyScheduledFlight(flight, schedule, flightNumber);
	}
	
	@DeleteMapping(value="/scheduledFlight/delete/{flightNumber}")
	public String deleteScheduledFlight(@PathVariable int flightNumber) {
		return flightService.deleteScheduledFlight(flightNumber);
	}
	
	//doubt
	@GetMapping(value="/scheduledFlight/search",produces= {"application/json"})
	public List<ScheduledFlight> viewScheduledFlights(@RequestBody Airport sourceAirport,@RequestBody Airport destinationAirport,@RequestBody LocalDate arrivalDate){
		return flightService.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
	}
}
