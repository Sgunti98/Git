package com.example.GSravanthi_Capstone.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.GSravanthi_Capstone.model.prescription;

public interface prescriptionRepository extends JpaRepository<prescription,String>{
	
	List<prescription> findByPatientName(String patientName);

}
