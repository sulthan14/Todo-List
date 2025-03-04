package com.example.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/todo") // localhost:8080/todo
public class ToDoController {
	@GetMapping
	public String show_todo_list (Model model,HttpSession session)
	{
		List<String> tasks=(List<String>) session.getAttribute("tasks");
		if(tasks==null) {
			tasks =new ArrayList<String>();
			session.setAttribute("tasks", tasks);
		}
		model.addAttribute("tasks",tasks);
		return "todo";
	}
	@PostMapping("/add")
	  public String add_todo(@RequestParam String task, HttpSession session) {
		List<String> tasks=(List<String>) session.getAttribute("tasks");
		if(tasks==null) {
			tasks =new ArrayList<String>();
			session.setAttribute("tasks", tasks); 
	  }
		tasks.add(task);
		return"redirect:/todo";
	}
	@PostMapping("/delete")
	  public String delete_todo(@RequestParam int index, HttpSession session) {
		List<String> tasks=(List<String>) session.getAttribute("tasks");
		tasks.remove(index);
		return"redirect:/todo";
	}
	@PostMapping("/delete_all")
	  public String deleteAll( HttpSession session) {
		
		   session.removeAttribute("tasks");
		   return"redirect:/todo";
			}
	
	
	
	
	
	
	
	
	
	
	
}
  

