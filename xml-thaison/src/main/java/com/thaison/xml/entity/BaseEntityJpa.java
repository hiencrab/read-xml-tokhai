package com.thaison.xml.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityJpa implements Serializable {
	private static final long serialVersionUID = 1L;

    @Column(name = "CREATED_BY", updatable = false)
    public String createdBy;

    @Column(name = "UPDATED_BY")
    public String updatedBy;

    @Column(name = "ACTIVE")
    public Boolean active;

    @Column(name = "VERSION")
    public Long version;

    @Column(name = "CREATED_DATETIME", columnDefinition = "TIMESTAMP", updatable = false)
    public LocalDateTime createdDate;

    @Column(name = "UPDATED_DATETIME", columnDefinition = "TIMESTAMP")
    public LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.createdDate)) {
            this.createdDate = LocalDateTime.now();
        }
        if (Objects.isNull(this.updatedDate)) {
            this.updatedDate = LocalDateTime.now();
        }
        if (Objects.isNull(this.active)) {
            this.active = true;
        }
        if (Objects.isNull(this.version)) {
            this.version = 0L;
        }
        if( Objects.isNull(this.createdBy)) {
            this.createdBy = "xml-thaison";
        }
        if( Objects.isNull(this.updatedBy)) {
            this.updatedBy = "xml-thaison";
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = "xml-thaison";
    }
}
