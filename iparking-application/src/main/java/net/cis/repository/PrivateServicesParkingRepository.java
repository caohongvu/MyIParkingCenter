package net.cis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cis.jpa.entity.PrivateServicesParkingEntity;

public interface PrivateServicesParkingRepository extends JpaRepository<PrivateServicesParkingEntity, Long> {

}
