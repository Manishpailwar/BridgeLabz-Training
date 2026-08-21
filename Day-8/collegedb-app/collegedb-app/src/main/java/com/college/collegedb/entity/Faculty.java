package com.college.collegedb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Year;

@Entity
@Table(name = "faculty")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "state", length = 20)
    private String state;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "joining_year")
    private Integer joiningYear;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
}
