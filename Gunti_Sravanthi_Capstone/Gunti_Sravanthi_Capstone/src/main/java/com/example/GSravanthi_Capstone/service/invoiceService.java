package com.example.GSravanthi_Capstone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.GSravanthi_Capstone.Repository.invoiceRepository;
import com.example.GSravanthi_Capstone.model.invoice;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class invoiceService {
	@Autowired
	private invoiceRepository rep;
	
	
	public void save(invoice entity) {
		rep.save(entity);
	}
	
	public List<invoice> view(){
		return rep.findAll();
	}

}
