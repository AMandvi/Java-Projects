package com.mandvi.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mandvi.savetravels.models.Expense;
import com.mandvi.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseServ;

	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> allDaExpenses = expenseServ.allExpenses();
		model.addAttribute("allDaExpenses", allDaExpenses);
		return "index.jsp";
	}

//	//CREATE METHOD - REDIRECT
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,
			RedirectAttributes flash, Model model) {
		if (result.hasErrors()) {
			List<Expense> allDaExpenses = expenseServ.allExpenses();
			model.addAttribute("allDaExpenses", allDaExpenses);
			return "index.jsp";
		} else {
			expenseServ.createExpense(expense);
//            flash.addFlashAttribute("success", "cool you made a book!!");
			return "redirect:/expenses";
		}

	}

	// EDIT PAGE
	@GetMapping("expenses/edit/{id}")
	public String updateExpense(@PathVariable("id") Long id, Model model) {
//			System.out.println(id);
		Expense expense = expenseServ.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}

	// EDIT METHOD
	@RequestMapping(value = "expenses/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseServ.updateExpense(expense);
			return "redirect:/expenses";
		}
	}

	// DElETE
	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/expenses";
	}

	// SHOW ONE
	@GetMapping("/expenses/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Expense thisExpense = expenseServ.findExpense(id);
		model.addAttribute("thisExpense", thisExpense);
		return "showOne.jsp";
	}

}
