package app.huanying.com.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.huanying.com.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	List<Reservation> findByReservationTime(LocalTime time);
	Reservation findByReservationId(String id);
}
