package com.thaison.xml.repository;

import com.thaison.xml.entity.GoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GoodItemRepository extends JpaRepository<GoodItemEntity, Long> {

    List<GoodItemEntity> findByDeclarationReportIdInAndActive(Collection<Long> declarationIds, Boolean active);

    List<GoodItemEntity> findByDeclarationReportIdOrderByIdAsc(Long declarationReportId);

    long countByDeclarationReportIdAndActive(Long declarationReportId, Boolean active);

    @Query("SELECT g.declarationReportId, COUNT(g) FROM GoodItemEntity g "
            + "WHERE g.active = true AND g.declarationReportId IN :ids GROUP BY g.declarationReportId")
    List<Object[]> countActiveByDeclarationIds(@Param("ids") Collection<Long> ids);

    @Modifying
    @Query("UPDATE GoodItemEntity g SET g.active = :active WHERE g.id IN :ids")
    void updateActiveByIds(@Param("ids") List<Long> ids, @Param("active") Boolean active);
}
