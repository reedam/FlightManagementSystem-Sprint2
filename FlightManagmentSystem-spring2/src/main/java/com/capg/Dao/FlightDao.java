package com.capg.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;

@Repository
@Transactional
public class FlightDao 
{
	
	@PersistenceContext
	EntityManager em;
	
	public String scheduleFlight(ScheduledFlight sf)
	{
		em.persist(sf);
		return "Flight scheduled successfully";
	}
	
	
	
	public List<ScheduledFlight> viewScheduledFlights()
	{
		Query query=em.createQuery("select sf from ScheduledFlight sf");
		return query.getResultList();
	}
	
	
	
	public ScheduledFlight viewScheduledFlight(int flightNumber)
	{
		List<ScheduledFlight> list=viewScheduledFlights();
		ScheduledFlight scheduledFlight=null;
		Optional <ScheduledFlight> optional=list.stream().
				filter(sf1->sf1.getFlight().getFlightNumber()==flightNumber).findFirst();
		if(optional.isPresent())
		{
			scheduledFlight=optional.get();
		}
		return scheduledFlight;
	}
	
	
	public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
		
		
		List<ScheduledFlight> list=viewScheduledFlights();
		Optional <ScheduledFlight> optional=list.stream().
				filter(sf1->sf1.getFlight().getFlightNumber()==flightNumber).findFirst();
		if(optional.isPresent())
		{
			em.merge(flight);
			em.merge(schedule);
		}
		return "modified successfully";
	}
	
	
	public String deleteScheduledFlight(int flightNumber) {
		em.remove(viewScheduledFlight(flightNumber));
		return "deleted scheduled flight successfully";
	}
	
	
	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate)
	{
		Query query=em.createQuery("select sf from ScheduledFlight sf where SourceAirport="+sourceAirport+
				"AND DestinationAirport="+destinationAirport+" AND ArrivalDate="+arrivalDate);
		return query.getResultList();
	}
	
}
