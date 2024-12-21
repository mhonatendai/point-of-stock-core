package com.tenstech.pointofstock.model;

   import com.tenstech.pointofstock.common.enums.Gender;
   import jakarta.persistence.*;
   import lombok.AllArgsConstructor;
   import lombok.Getter;
   import lombok.NoArgsConstructor;
   import lombok.Setter;

@Setter
@Getter
   @Entity
   @NoArgsConstructor
   @AllArgsConstructor
   @Table(name = "app_user")
   public class User extends AuditedEntity{

       @Column(nullable = false, unique = true)
       private String username;

       @Column(nullable = false)
       private String password;

       @Column(nullable = false)
       private String roles;

       @Column(unique = true)
       private String email;

       @Column
       private String phone;

       @Column
       private String address;

       @Column
       private String city;

       @Column
       private String country;

       @Column
       private String firstName;

       @Column
       private String lastName;

       @Column
       @Enumerated(EnumType.STRING)
       private Gender gender;

       @Column
       private Boolean accountNonExpired;

       @Column
       private Boolean accountNonLocked;

       @Column
       private Boolean enabled;

}