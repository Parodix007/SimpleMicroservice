package com.parodix.SimpleMicroservice.services;

import com.parodix.SimpleMicroservice.dtos.CustomerDTO;
import com.parodix.SimpleMicroservice.repositories.CustomerRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public final class CustomerService {

  private final CustomerRepo customerRepo;

  public CustomerService(final CustomerRepo customerRepo) {
    this.customerRepo = customerRepo;
  }

  public List<CustomerDTO> getCustomers() {
    System.out.println("invocation");
    return customerRepo.findAll().stream().map(customer -> new CustomerDTO(customer.getCreditId(),
            customer.getFirstName(), customer.getPESEL(), customer.getLastName()))
        .collect(Collectors.toList());
  }
}
