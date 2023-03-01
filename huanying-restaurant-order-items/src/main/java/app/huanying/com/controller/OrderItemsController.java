package app.huanying.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.huanying.com.model.OrderItems;
import app.huanying.com.repository.OrderItemsRepository;

@CrossOrigin
@RestController
@RequestMapping("/order-items")
public class OrderItemsController {

	@Autowired
	OrderItemsRepository repo;

	@PostMapping("/add")
	public ResponseEntity<?> createOrder(@RequestBody OrderItems request) {

		OrderItems result = repo.save(request);

		if (result != null) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@DeleteMapping("/delete-order")
	public ResponseEntity<?> deleteOrderItem(@RequestBody Long id){
		
		List<OrderItems> results = repo.findRecordsWithMatchingId(id);
		
		if (results != null) {
			
			for(OrderItems result : results ) {
				repo.delete(result);
			}
			
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
