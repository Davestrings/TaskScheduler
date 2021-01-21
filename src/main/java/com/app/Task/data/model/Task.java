package com.app.Task.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String type;

    @Column(length = 1000, name = "description")
    private String description;

    @Column(length = 5000, name = "details")
    private String detail;

    @Column(name = "comments")
    private String comment;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredAt;

    @JoinColumn(columnDefinition = "assignee_user_id", name = "assignee_user_id")
    @ManyToOne(optional = false)
    private AppUser assignee;

    @JoinColumn(columnDefinition = "project_id")
    @ManyToOne(optional = false)
    private Project project;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;
}
