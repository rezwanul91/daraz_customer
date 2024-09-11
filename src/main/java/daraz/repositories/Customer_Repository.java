package daraz.repositories;

import daraz.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_Repository extends JpaRepository<Customer,Integer> {
}
