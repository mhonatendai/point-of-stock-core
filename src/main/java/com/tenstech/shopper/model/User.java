package com.tenstech.shopper.model;

   import jakarta.persistence.*;
   import lombok.AllArgsConstructor;
   import lombok.Getter;
   import lombok.NoArgsConstructor;
   import lombok.Setter;

   @Entity
   @NoArgsConstructor
   @AllArgsConstructor
   @Getter
   @Setter
   public class User extends BaseEntity{

       @Column(nullable = false, unique = true)
       private String username;

       @Column(nullable = false)
       private String password;

       @Column(nullable = false)
       private String roles;
   }