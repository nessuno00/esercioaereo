package Controller;

import com.example.demo.FlightsDto;
import com.example.demo.flights.FlightService;
import com.example.demo.flights.Flights;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/flights")
    public class Controller {

        private final FlightService flightService;

        public Controller(FlightService flightService) {
            this.flightService = flightService;
        }

        @GetMapping("/get-all")
        public List<Flights> getAll() {
            return flightService.getAll();
        }

        @PostMapping("/generate")
        public String generate(@RequestParam(required = false) Integer n) {
            if (n == null) {
                n = 100;
            }
            flightService.generate(n);
            return "Generated";
        }

        @GetMapping("/get-all-pag")
        public FlightsDto getAllPaginated(int limit, int page) {
            return flightService.getAllPaginated(limit, page);
        }

        @GetMapping("/get-by-multiple-status")
        public FlightsDto getByStatus(@RequestParam Flights.Status s1, Flights.Status s2, int limit, int page) {
            return flightService.getAllByStatus(s1, s2, limit, page);
        }

        @GetMapping("/get-by-status")
        public FlightsDto getByStatus(@RequestParam(required = false) Flights.Status s1, int limit, int page) {
            if (s1 == null) {
                s1 = Flights.Status.ON_TIME;
            }
            return flightService.getAllByStatus(s1, limit, page);
        }

    }

