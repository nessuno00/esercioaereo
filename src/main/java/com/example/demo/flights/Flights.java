package com.example.demo.flights;



import jakarta.persistence.*;
@Entity
    public class Flights {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String description;
        private String fromAirport;
        private String toAirport;

        public Flights(Long id, String description, String fromAirport, String toAirport, Status status) {
            this.id = id;
            this.description = description;
            this.fromAirport = fromAirport;
            this.toAirport = toAirport;
            this.status = status;
        }

        public Flights() {
        }

        @Enumerated(EnumType.STRING)
        private Status status;

        public enum Status {
            ON_TIME, DELAYED, CANCELLED;
        }

        public Long getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFromAirport() {
            return fromAirport;
        }

        public void setFromAirport(String fromAirport) {
            this.fromAirport = fromAirport;
        }

        public String getToAirport() {
            return toAirport;
        }

        public void setToAirport(String toAirport) {
            this.toAirport = toAirport;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }


        public static final class FlightsBuilder {
            private Long id;
            private String description;
            private String fromAirport;
            private String toAirport;
            private Status status = Status.ON_TIME;

            private FlightsBuilder() {
            }

            public static FlightsBuilder aFlights() {
                return new FlightsBuilder();
            }

            public FlightsBuilder withId(Long id) {
                this.id = id;
                return this;
            }

            public FlightsBuilder withDescription(String description) {
                this.description = description;
                return this;
            }

            public FlightsBuilder withFromAirport(String fromAirport) {
                this.fromAirport = fromAirport;
                return this;
            }

            public FlightsBuilder withToAirport(String toAirport) {
                this.toAirport = toAirport;
                return this;
            }

            public FlightsBuilder withStatus(Status status) {
                this.status = status;
                return this;
            }

            public Flights build() {
                return new Flights(id, description, fromAirport, toAirport, status);
            }
        }
    }

