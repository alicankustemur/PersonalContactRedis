package com.tr.t2.personalcontact.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tr.t2.personalcontact.dao.PersonRepository;
import com.tr.t2.personalcontact.domain.Person;
import com.tr.t2.personalcontact.service.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({("classpath:test-config.xml")})
public class PersonServiceIntegrationTest
{
	@Autowired
	private PersonServiceImpl	service;

	@Autowired
	private PersonRepository	repository;

	@Before
	public void setup()
	{
		//		service.setRepository(repository);
		//		repository.deleteAll();
	}

	@Rollback(true)
	@Test
	public void testAddPerson() throws Exception
	{
		Person person = new Person("1", "Ali Can", "Kuştemur");
		service.addPerson(person);
		assertThat(service.getPerson(person.getId()), is(notNullValue()));
	}

	@Rollback(true)
	@Test
	public void testGetPerson() throws Exception
	{
		Person person = new Person("1", "Ali Can", "Kuştemur");
		service.addPerson(person);
		assertEquals(person.getId(), service.getPerson(person.getId()).getId());
		assertEquals(person.getName(), service.getPerson(person.getId()).getName());
		assertEquals(person.getSurname(), service.getPerson(person.getId()).getSurname());
	}

	@Rollback(true)
	@Test
	public void testDeletePerson() throws Exception
	{
		Person person = new Person("1", "Ali Can", "Kuştemur");
		service.addPerson(person);
		service.deletePerson(person.getId());
		assertThat(service.getPerson(person.getId()), is(nullValue()));
	}

	@Rollback(true)
	@Test
	public void testGetAllPersonsForOneUser() throws Exception
	{
		Person person = new Person("1", "Ali Can", "Kuştemur");
		service.addPerson(person);
		List<Person> persons = service.getAllPersons();
		assertThat(persons.size(), is(equalTo(1)));
	}

	@Rollback(true)
	@Test
	public void testGetAllPersonsForThreeUser() throws Exception
	{
		Person person = new Person("1", "Ali Can", "Kuştemur");
		Person person2 = new Person("2", "Ali Can", "Kuştemur");
		Person person3 = new Person("3", "Ali Can", "Kuştemur");
		service.addPerson(person);
		service.addPerson(person2);
		service.addPerson(person3);
		List<Person> persons = service.getAllPersons();
		assertThat(persons.size(), is(equalTo(3)));
	}

}
