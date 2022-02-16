package com.Lms.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Lms.DTO.SearchDto;
import com.Lms.Entity.Instructor;
import com.Lms.ServiceLayer.InstructorService;

@Controller
public class LmsController {

	@Autowired
	private InstructorService instructorService;

	@RequestMapping("/home")
	public String display(Model model) {
		
		List<Instructor> fetchAllInstructor = instructorService.fetchAllInstructor();
		
		model.addAttribute("SearchDto", new SearchDto());
		model.addAttribute("instructor", fetchAllInstructor);
		
		for(Instructor temp:fetchAllInstructor) {
			System.out.println(temp);
		}
		
		return "Home";
	}
	
	
	@GetMapping("/add-instructor")
	public String addInstructorMethod(@ModelAttribute("InstructorDto")Instructor instructor) {
		
		return "Add-Instructor";
	}

	
	@PostMapping("/saveData")
    public String saveInstructor( @Valid @ModelAttribute("InstructorDto")Instructor instructor, BindingResult result) {
		

		if (result.hasErrors()) {
			return "Add-Instructor";
		}
		
		System.out.println(instructor);
		instructorService.saveInstructor(instructor);
		
		return "redirect:/home"; // return "redirect:/login";
	}

	
	
	@PostMapping("/search-id")
    public String searchById(@RequestParam("id") int id,Model model,SearchDto searchDto) {
		
		ArrayList<Instructor> instructors=new ArrayList<Instructor>();
		
		model.addAttribute("SearchDto", searchDto);
		
		Instructor instructor = instructorService.searchInstructor(id);
		System.out.println(instructor);
		instructors.add(instructor);
		
		model.addAttribute("instructor", instructors);

		return "Home";
	}
	
	@RequestMapping("/delete-instructor")
	public String deleteInstructor(@RequestParam("id") int id) {

		instructorService.deleteInstructorById(id);

		return "redirect:/home";
	}
	

	
	
	
	
}
