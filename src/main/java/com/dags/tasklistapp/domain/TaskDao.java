package com.dags.tasklistapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_list")
@Data
@NoArgsConstructor
public class TaskDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String description;
    Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDao_id", updatable = false, nullable = false)
    @JsonIgnore
    private UserDao userDao;

    @PrePersist
    public void onCreated(){
        this.dateCreated = new Date();
    }
}
