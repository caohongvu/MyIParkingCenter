package net.cis.repository.iparking.center;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.cis.jpa.entity.TicketEntity;

/**
 * Created by Vincent 02/10/2018
 */

public interface TicketRepository  extends JpaRepository<TicketEntity, Long> {
	
	@Query(value = "Select ticket from TicketEntity ticket where (parkingPlace =:cppId OR :cppId is NULL) AND (inSession =:inSession OR :inSession is NULL) order by createdAt DESC")
	public List<TicketEntity> findAll(@Param("cppId") Long cppId, @Param("inSession") Boolean inSession, Pageable pageable);
}
