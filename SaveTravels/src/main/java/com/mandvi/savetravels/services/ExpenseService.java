package com.mandvi.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.savetravels.models.Expense;
import com.mandvi.savetravels.repos.ExpenseRepo;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	// ======FULL CRUD ======   
		    
		    // READ ALL
		    public List<Expense> allExpenses() {
		        return expenseRepo.findAll();
		    }
		    // CREATE
		    public Expense createExpense(Expense expense) {
		        return expenseRepo.save(expense);
		    }
		    // READ ONE
		    public Expense findExpense(Long id) {
		        Optional<Expense> optionalExpense = expenseRepo.findById(id);
		        
		        if(optionalExpense.isPresent()) {
		            return optionalExpense.get();
		        } else {
		            return null;
		        }
		    }
		    
		    //UPDATE
		    public Expense updateExpense(Expense expense) {
		    	Expense updateExpense = expenseRepo.save(expense);
		    	return updateExpense;
		    }
		    
		    //DELETE //deleteById returns void thats why void method
		    public void deleteExpense(Long id) {
		    	expenseRepo.deleteById(id);
		    }
	

}
