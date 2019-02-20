package dao;


import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>{

	List<Customer> findByEmail(String email);
	
	List<Customer> findByDate(Date date);
		
}
	
