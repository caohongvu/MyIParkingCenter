package net.cis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.cis.jpa.entity.ParkingContractEntity;

/**
 * Created by Vincent 02/10/2018
 */

public interface ParkingContractRepository  extends JpaRepository<ParkingContractEntity, Long> {
	
	List<ParkingContractEntity> findByCusId(long cusId);
	
	
	@Query(value = "Select ticket from ParkingContractEntity ticket where (parkingPlace =:cppCode OR :cppCode is NULL) AND ((validFrom <= :fromDate AND validEnd <= :toDate ) OR (validFrom >= :fromDate AND validFrom <= :toDate ) OR (validEnd >= :fromDate AND validEnd <= :toDate ))  order by createdAt DESC")
	public List<ParkingContractEntity> findAll(@Param("cppCode") String cppCode, @Param("fromDate") long fromDate,
			@Param("toDate") long toDate);
	
	@Query(value = "Select ticket from ParkingContractEntity ticket where (parkingPlace =:cppCode OR :cppCode is NULL) AND (validEnd < CURRENT_TIMESTAMP() )  order by createdAt DESC")
	public List<ParkingContractEntity> findParkingContractOutOfDate(@Param("cppCode") String cppCode);
}
