package com.example.demo;


import com.example.demo.flights.Flights;
import org.springframework.http.HttpStatus;

import java.util.List;

public class FlightsDto extends Pagination{
    List<Flights> flights;

    public FlightsDto() {
    }


    public static final class FlightsDtoBuilder {
        private List<Flights> flights;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private FlightsDtoBuilder() {
        }

        public static FlightsDtoBuilder aFlightsDto() {
            return new FlightsDtoBuilder();
        }

        public FlightsDtoBuilder withFlights(List<Flights> flights) {
            this.flights = flights;
            return this;
        }

        public FlightsDtoBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public FlightsDtoBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public FlightsDtoBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public FlightsDtoBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public FlightsDtoBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public FlightsDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public FlightsDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public FlightsDto build() {
            FlightsDto flightsDto = new FlightsDto();
            flightsDto.setPage(page);
            flightsDto.setPageSize(pageSize);
            flightsDto.setTotalElements(totalElements);
            flightsDto.setTotalPages(totalPages);
            flightsDto.setHttpStatus(httpStatus);
            flightsDto.setMessage(message);
            flightsDto.setDescription(description);
            flightsDto.flights = this.flights;
            return flightsDto;
        }
    }
}

