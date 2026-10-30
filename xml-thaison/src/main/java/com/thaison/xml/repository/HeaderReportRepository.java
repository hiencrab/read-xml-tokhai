package com.thaison.xml.repository;

import com.thaison.xml.entity.HeaderReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaderReportRepository extends JpaRepository<HeaderReportEntity, Long> {

    @Modifying
    @Query("UPDATE HeaderReportEntity h SET h.active = :active WHERE h.id IN :ids")
    void updateActiveByIds(@Param("ids") List<Long> ids, @Param("active") Boolean active);
}
