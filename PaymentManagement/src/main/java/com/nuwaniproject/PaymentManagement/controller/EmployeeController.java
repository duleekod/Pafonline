package com.nuwaniproject.PaymentManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuwaniproject.PaymentManagement.dao.PaymentDAO;
import com.nuwaniproject.PaymentManagement.model.Payment;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	PaymentDAO paymentDAO;
	
	/*to save a payment*/
	@PostMapping("/payments")
	public Payment createPayment(@Valid @RequestBody Payment pay) {
		return paymentDAO.save(pay);
	}
	
	/*get all payments*/
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentDAO.findAll();
	}
	
	/*get payment by payid*/
	
	@GetMapping("/payments")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="id") Long payid){
		
		Payment pay=paymentDAO.findOne(payid);
		
		if(pay==null) {
			return ResponseEntity.notFound().build();
			
		}
		return ResponseEntity.ok().body(pay);
		
	}
	
	/*Update a payment*/
	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="id") Long payid,@Valid @RequestBody Payment paymentDetails){
		Payment pay=paymentDAO.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		
		pay.setType(paymentDetails.getType());
		pay.setAmount(paymentDetails.getAmount());
		pay.setDescription(paymentDetails.getDescription());
		
		Payment updatePayment=paymentDAO.save(pay);
		
		return ResponseEntity.ok().body(updatePayment);
	}
	
	/*delete a payment*/
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable(value="id") Long payid){
		
		Payment pay=paymentDAO.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		paymentDAO.delete(pay);
		
		return null;
		
	}
	
	
}
