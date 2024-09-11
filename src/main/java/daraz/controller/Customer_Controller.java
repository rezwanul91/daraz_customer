package daraz.controller;

import daraz.entity.Customer;
import daraz.repositories.Customer_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class Customer_Controller {
    @Autowired
    Customer_Repository customerRepository;
    @PostMapping("/insertCust")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/allCust")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
      Customer cust =  customerRepository.findById(id).orElse(null);
      if (cust != null){
          return ResponseEntity.ok(cust);
      }
      return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustBYId(@PathVariable Integer id, @RequestBody Customer updateCust){
      Customer updateCustomer =  customerRepository.findById(id).orElse(null);
        if (updateCustomer != null){
            updateCustomer.setName(updateCust.getName());
            updateCustomer.setAddress(updateCust.getAddress());
            updateCustomer.setEmail(updateCust.getEmail());
            updateCustomer.setRewardPoint(updateCust.getRewardPoint());
            customerRepository.save(updateCustomer);
            return ResponseEntity.ok(updateCustomer);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Integer id){
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllCustomer(){
        customerRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
