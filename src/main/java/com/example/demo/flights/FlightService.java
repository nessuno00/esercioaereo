package com.example.demo.flights;

import com.example.demo.FlightsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
    public class FlightService {
        private final FlightsDao flightsDao;

        private final Random random = new Random();

        public FlightService(FlightsDao flightsDao) {
            this.flightsDao = flightsDao;
        }

        public List<Flights> getAll() {
            return flightsDao.findAll();
        }

        public void generate(int n) {
            Flights.Status[] statuses = Flights.Status.values();
            for (int i = 0; i < n; i ++) {
                flightsDao.save(Flights.FlightsBuilder.aFlights().withDescription(UUID.randomUUID().toString()).withFromAirport(UUID.randomUUID().toString()).withToAirport(UUID.randomUUID().toString()).withStatus(statuses[random.nextInt(statuses.length)]).build());
            }
        }

        public FlightsDto getAllPaginated(int limit, int page) {
            Page<Flights> flights = flightsDao.findAll(PageRequest.of(page, limit));
            return FlightsDto.FlightsDtoBuilder.aFlightsDto()
                    .withHttpStatus(HttpStatus.OK)
                    .withFlights(flights.toList())
                    .withPage(flights.getPageable().getPageNumber())
                    .withPageSize(flights.getPageable().getPageSize())
                    .withTotalElements(flights.getTotalElements())
                    .withTotalPages(flights.getTotalPages())
                    .build();
        }

        public FlightsDto getAllByStatus(Flights.Status s1, Flights.Status s2, int limit, int page) {
            Page<Flights> flights = flightsDao.getByStatusAndStatus(s1, s2, PageRequest.of(page, limit));
            return FlightsDto.FlightsDtoBuilder.aFlightsDto()
                    .withHttpStatus(HttpStatus.OK)
                    .withFlights(flights.toList())
                    .withTotalElements(flights.getTotalElements())
                    .withTotalPages(flights.getTotalPages())
                    .withPageSize(flights.getPageable().getPageSize())
                    .withPage(flights.getPageable().getPageNumber())
                    .build();
        }


        public FlightsDto getAllByStatus(Flights.Status s1, int limit, int page) {
            Page<Flights> flights = flightsDao.getFlightsByStatus(s1, PageRequest.of(page, limit));
            return FlightsDto.FlightsDtoBuilder.aFlightsDto()
                    .withHttpStatus(HttpStatus.OK)
                    .withFlights(flights.toList())
                    .withPageSize(flights.getPageable().getPageSize())
                    .withPage(flights.getPageable().getPageNumber())
                    .withTotalPages(flights.getTotalPages())
                    .withTotalElements(flights.getTotalElements())
                    .build();
        }
    }

