package com.tr.t2.personalcontact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tr.t2.personalcontact.domain.Person;
import com.tr.t2.personalcontact.service.PersonService;

@Controller

public class PersonController
{

	@Autowired
	private PersonService service;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView modelAndView)
	{

		List<Person> persons = service.getAllPersons();
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("person", new Person());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute Person person)
	{

		service.addPerson(person);

		return "redirect:/";
	}

	@RequestMapping("deletePerson")
	public String deletePerson(@RequestParam String id)
	{

		service.deletePerson(id);

		return "redirect:/";
	}

	@RequestMapping("updatePerson")
	public ModelAndView updatePerson(ModelAndView modelAndView, @RequestParam String id)
	{

		List<Person> persons = service.getAllPersons();
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("person", service.getPerson(id));
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
