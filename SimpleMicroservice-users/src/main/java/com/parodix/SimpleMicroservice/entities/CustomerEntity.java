package com.parodix.SimpleMicroservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int creditId;

  @NotNull
  @Column(length = 64)
  private String firstName;

  @NotNull
  @Column(unique = true, length = 12)
  private double PESEL;

  @NotNull
  @Column(length = 64)
  private String lastName;
}
