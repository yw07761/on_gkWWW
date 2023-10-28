package com.example.demo1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name = "getExperiencesByCanId", query = "SELECT * FROM experience_abc WHERE can_id = ?1", resultClass = Experience.class)
@Entity(name = "experience_abc")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "from_date", columnDefinition = "date")
    private LocalDate fromDate;
    @Column(name = "to_date", columnDefinition = "date")
    private LocalDate toDate;
    @Enumerated
    private Roles role;
    @Column(name = "work_desc", columnDefinition = "varchar(400)")
    private String workDescription;
    @Column(name = "company", columnDefinition = "varchar(120)")
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
}
