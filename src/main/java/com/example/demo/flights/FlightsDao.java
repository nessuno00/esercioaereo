package com.example.demo.flights;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsDao extends JpaRepository<Flights, Long> {
    @Query(nativeQuery = true, value = "select * from flights where flights.status = :s1 and flight.status = :s2")
    Page<Flights> getByStatusAndStatus(@Param("s1") Flights.Status s1, @Param("s2") Flights.Status s2, Pageable pageable);

    Page<Flights> getFlightsByStatus(Flights.Status status, Pageable pageable);
}