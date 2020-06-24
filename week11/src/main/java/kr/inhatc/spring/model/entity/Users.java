package kr.inhatc.spring.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String account;
  private String password;

  private String name;
  private String email;

  @CreationTimestamp
  @Column(columnDefinition = "timestamptz default now()")
  private LocalDateTime joinDate;

  @Column(columnDefinition = "bool default true")
  private Boolean enabled;
  private String role;
}