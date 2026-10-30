package com.thaison.xml.repository;

import com.thaison.xml.entity.DeclarationReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationReportRepository extends JpaRepository<DeclarationReportEntity, Long>,
        JpaSpecificationExecutor<DeclarationReportEntity> {

    List<DeclarationReportEntity> findByDeclarationNoInAndActive(List<String> declarationNos, Boolean active);

    List<DeclarationReportEntity> findByActiveOrderByIdAsc(Boolean active);

    @Modifying
    @Query("UPDATE DeclarationReportEntity d SET d.active = :active WHERE d.id IN :ids")
    void updateActiveByIds(@Param("ids") List<Long> ids, @Param("active") Boolean active);
}
