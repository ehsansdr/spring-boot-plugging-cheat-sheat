package com.example.demo.Tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {

    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String phoneNumber;
    @OneToMany(mappedBy = "TeacherId",
            cascade = CascadeType.ALL)  /** if i perform or if i delete below object
                                            automatically i will remove this object from the
                                            below table and you do not need to do that
                                            */
    List<Teacher> teacher;
}
