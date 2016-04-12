package com.tr.t2.personalcontact.dao;

import java.util.List;

import com.tr.t2.personalcontact.domain.Person;

public interface PersonRepository
{

	public void save(Person person);

	public Person findOne(String id);

	public List<Person> findAll();

	public void delete(String id);

	public void deleteAll();
}
