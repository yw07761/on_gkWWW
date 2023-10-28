package com.example.demo1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "candidate")
@NamedNativeQuery(name = "getCandidatesByRole",
        query = "SELECT candidate.* FROM candidate INNER JOIN experience_abc ON candidate.can_id = experience_abc.can_id WHERE ROLE = ?1",
        resultClass = Candidate.class)
@NamedNativeQuery(name = "getCandidatesIsGmail", query = "SELECT * FROM candidate WHERE email LIKE '%@gmail%'", resultClass = Candidate.class)
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
