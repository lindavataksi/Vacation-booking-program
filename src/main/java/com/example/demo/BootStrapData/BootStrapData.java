package com.example.demo.BootStrapData;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entity.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


//    @Override
//    public void run (String... args) throws Exception{
    @PostConstruct
    public void loadInitialCustomerData(){

        if (customerRepository.count() == 1){
            Customer customer1 = new Customer();
            customer1.setFirstName("Linda");
            customer1.setLastName("Vataksi");
            customer1.setAddress("35 West Falcon Ave");
            customer1.setPostal_code("12304");
            customer1.setPhone("9175657898");
            customer1.setDivision(divisionRepository.findAll().get(7));
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());

            Customer customer2 = new Customer();
            customer2.setFirstName("Shelly");
            customer2.setLastName("Crawford");
            customer2.setAddress("350 Bank Ave");
            customer2.setPostal_code("89984");
            customer2.setPhone("9177894523");
            customer2.setDivision(divisionRepository.findAll().get(1));
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());

            Customer customer3 = new Customer();
            customer3.setFirstName("Taylor");
            customer3.setLastName("Swift");
            customer3.setAddress("100 Hollywood Blvd");
            customer3.setPostal_code("90210");
            customer3.setPhone("91767909878");
            customer3.setDivision(divisionRepository.findAll().get(2));
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());

            Customer customer4 = new Customer();
            customer4.setFirstName("Martin");
            customer4.setLastName("Luther");
            customer4.setAddress("234 Washington Street");
            customer4.setPostal_code("93042");
            customer4.setPhone("7484939876");
            customer4.setDivision(divisionRepository.findAll().get(3));
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());

            Customer customer5 = new Customer();
            customer5.setFirstName("Rihanna");
            customer5.setLastName("Fenty");
            customer5.setAddress("465 Barbados Ave");
            customer5.setPostal_code("10200");
            customer5.setPhone("9174546787");
            customer5.setDivision(divisionRepository.findAll().get(1));
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);
    }



    }
}
