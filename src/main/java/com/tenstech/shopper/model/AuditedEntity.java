package com.tenstech.shopper.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
public abstract class AuditedEntity implements Serializable {

    protected LocalDateTime created;
    protected LocalDateTime lastModified;
    protected String createdBy;
    protected String modifiedBy;

    @CreatedDate
    @Column(name = "created", nullable = false, updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }


    @LastModifiedDate
    @Column(name = "last_modified")
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    private void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Column(name = "created_by")
    @CreatedBy
    public String getCreatedBy() {
        return createdBy;
    }


    @Column(name = "last_modified_by")
    @LastModifiedBy
    public String getModifiedBy() {
        return modifiedBy;
    }
}