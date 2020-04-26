package com.capg;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.Dao.FlightDao;
import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;

@SpringBootApplication
public class FlightManagmentSystemSpring2Application implements CommandLineRunner{
	
	@Autowired
	FlightDao flightdao;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagmentSystemSpring2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("You are using Flight Management System.");
		
		
		ScheduledFlight sf = new ScheduledFlight(12355,new Flight(12355,"BS2WJ","1562",50), 50, new Schedule(new Airport("Bengaluru International Airport", "VOBG", "Bangalore"), new Airport("Bhopal Airport", "VABP", "Bhopal"), LocalDate.of(2019, 5, 10),LocalDate.of(2019, 5, 11)));
		ScheduledFlight sf1 = new ScheduledFlight(12365,new Flight(12365,"BS2WW","4162",60), 40, new Schedule(new Airport("AAhmedabad Airport", "VAAH", "Ahmedabad"), new Airport("Amausi Airport", "VILK", "Lucknow"),  LocalDate.of(2019, 5, 10),LocalDate.of(2019, 5, 11)));
		ScheduledFlight sf2 = new ScheduledFlight(12385,new Flight(12385,"BS2W2","4561",40), 35, new Schedule(new Airport("Chandigarh Airport", "VICG", "Chandigarh"), new Airport("	Devi Ahilyabai Holkar Airport", "VAID", "Indore"),  LocalDate.now(),  LocalDate.now()));
		
		flightdao.scheduleFlight(sf);
		flightdao.scheduleFlight(sf1);
		flightdao.scheduleFlight(sf2);
		
	}

}
