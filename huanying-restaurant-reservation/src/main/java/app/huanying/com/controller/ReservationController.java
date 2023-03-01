package app.huanying.com.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.huanying.com.model.Reservation;
import app.huanying.com.repository.ReservationRepository;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	ReservationRepository repo;

	/*
	 * ************************************GET
	 * METHODS**********************************************
	 */
	@GetMapping("/get-all-records")
	public List<Reservation> getAllReservations() {
		List<Reservation> list = repo.findAll();

		List<Reservation> sortedList = list.stream()
				.filter( result -> result.isHasCancelled() != true)
				.sorted(Comparator.comparing(Reservation::getReservationTime))
				.collect(Collectors.toList());

		return sortedList;
	}

	@GetMapping("/reserved/{id}")
	public Reservation getById(@PathVariable Long id) {
		Optional<Reservation> found = repo.findById(id);

		if (found.isEmpty()) {
			return null;
		}

		return found.get();
	}

	/*
	 * ************************************POST
	 * METHODS**********************************************
	 */

	@PostMapping("/create")
	public ResponseEntity<?> createReservations(@RequestBody Reservation request) {

		List<Reservation> list = repo.findByReservationTime(request.getReservationTime());

		if (list.isEmpty() || list.size() < 15) {

			Reservation res = repo.save(request);

			if (res != null) {
				return ResponseEntity.status(201).body(res);
			}
		}

		return ResponseEntity.status(400).build();
	}

	@PutMapping("/updateAll")
	public ResponseEntity<?> updateReservation(@RequestBody Reservation request) {

		Reservation query = repo.findByReservationId(request.getReservation_id());

		if (query != null) {
			repo.save(request);
			return ResponseEntity.status(200).build();
		}

		return ResponseEntity.status(400).build();
	}

	@PutMapping("/cancel/{id}")
	public ResponseEntity<?> cancelReservation(@RequestParam String id) {

		Reservation query = repo.findByReservationId(id);

		if (query != null) {
			query.setHasCancelled(true);
			repo.save(query);
			return ResponseEntity.status(200).build();
		}

		return ResponseEntity.status(400).build();
	}
}
