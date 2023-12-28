package com.lacerdadev.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private UUID id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant moment;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;
  // TODO - Limitar apenas o id na hora de retornar o objeto do client;

  public Order() {
  }

  public Order(Instant moment, User client) {
    super();
    this.id = UUID.randomUUID();
    this.moment = moment;
    this.client = client;
  }

  public UUID getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
  }

  public User getClient() {
    return client;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;

    if (getClass() != obj.getClass())
      return false;

    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}