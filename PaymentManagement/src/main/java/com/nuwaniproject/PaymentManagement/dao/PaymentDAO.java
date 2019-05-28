package com.nuwaniproject.PaymentManagement.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuwaniproject.PaymentManagement.model.Payment;
import com.nuwaniproject.PaymentManagement.repository.PaymentRepository;


@Service
public class PaymentDAO {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	/*to save a payment*/
	
	public Payment save(Payment pay) {
		return paymentRepository.save(pay);
	}
	/*search all payments*/
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	/* search a payment by id*/
	
	public Payment findOne(Long payid) {
		return paymentRepository.findById(payid).orElse(null);
	}
	     
	/*delete a payment */
	
	public void delete(Payment pay) {
		paymentRepository.delete(pay);
	}
}
