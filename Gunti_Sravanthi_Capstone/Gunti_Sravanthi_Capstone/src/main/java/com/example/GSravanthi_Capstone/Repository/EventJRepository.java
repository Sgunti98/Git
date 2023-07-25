package com.example.GSravanthi_Capstone.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.GSravanthi_Capstone.model.event;


public interface EventJRepository extends JpaRepository<event, Long> {
public List<event> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime end);
	
	public List<event> findByName(String name);
	
	public List<event> findByStart(LocalDateTime start);
	
	/* This one uses an @Query */
	@Query("select b from event b where b.start >= ?1 and b.finish <= ?2")
	public List<event> findByDateBetween(LocalDateTime start, LocalDateTime end);

}
