package com.tr.t2.personalcontact.domain;

import java.io.Serializable;

public class Person implements Serializable
{

	private static long	serialVersionUID	= 1L;

	private String		id;
	private String		name;
	private String		surname;

	public Person()
	{
	}

	public Person(String id, String name, String surname)
	{
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
