package app.huanying.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.huanying.com.model.OrderItems;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM order_items h WHERE h.order_item_id LIKE '?1%'")
	List<OrderItems> findRecordsWithMatchingId(Long id);
}
