package com.anhnbt.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "ip")
public class Ip {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false, length = 16)
    private String address;

    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

}