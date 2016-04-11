package com.tr.t2.personalcontact.service;

import java.util.List;

import com.tr.t2.personalcontact.domain.Person;

public interface PersonService
{
	public void addPerson(Person person);

	public Person getPerson(String id);

	public List<Person> getAllPersons();

	public void deletePerson(String id);
}
