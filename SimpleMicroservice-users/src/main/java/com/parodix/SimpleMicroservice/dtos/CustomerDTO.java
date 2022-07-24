package com.parodix.SimpleMicroservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CustomerDTO {
  private final int creditId;
  private final String firstName;
  private final long PESEL;
  private final String lastName;
}
