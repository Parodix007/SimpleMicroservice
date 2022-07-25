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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int creditId;

  @NotNull
  @Column(unique = true, length = 64)
  private String productName;

  @NotNull
  private long value;
}
