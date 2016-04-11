package com.tr.t2.personalcontact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.t2.personalcontact.dao.PersonRepository;
import com.tr.t2.personalcontact.domain.Person;

@Service
public class PersonServiceImpl implements PersonService
{

	@Autowired
	private PersonRepository repository;

	@Override
	public void addPerson(Person person)
	{
		repository.save(person);

	}

	@Override
	public Person getPerson(String id)
	{
		return repository.findOne(id);
	}

	@Override
	public List<Person> getAllPersons()
	{
		return repository.findAll();
	}

	@Override
	public void deletePerson(String id)
	{
		repository.delete(id);
	}

}
