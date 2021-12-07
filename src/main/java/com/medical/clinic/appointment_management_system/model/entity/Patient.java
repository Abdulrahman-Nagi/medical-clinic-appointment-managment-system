package com.medical.clinic.appointment_management_system.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    private String phoneNumber;

    @OneToMany(mappedBy="patient",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Appointment> appointments=new HashSet<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Instant creationDate;

    @LastModifiedDate
    @Column(nullable = false)
    protected Instant modificationDate;
}
