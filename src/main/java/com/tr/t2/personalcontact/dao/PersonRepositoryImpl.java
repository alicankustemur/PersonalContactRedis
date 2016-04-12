package com.tr.t2.personalcontact.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import com.tr.t2.personalcontact.domain.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository
{

	@Autowired
	private RedisTemplate<String, Person>	redisTemplate;

	private static String					PERSON_KEY	= "Person";

	public RedisTemplate<String, Person> getRedisTemplate()
	{
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Person> redisTemplate)
	{
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void save(Person person)
	{
		redisTemplate.opsForHash().put(PERSON_KEY, person.getId(), person);
	}

	@Override
	public Person findOne(String id)
	{
		return (Person)redisTemplate.opsForHash().get(PERSON_KEY, id);
	}

	@Override
	public List<Person> findAll()
	{
		List<Person> persons = new ArrayList<Person>();
		for (Object person : redisTemplate.opsForHash().values(PERSON_KEY))
		{
			persons.add((Person)person);
		}
		return persons;
	}

	@Override
	public void delete(String id)
	{
		redisTemplate.opsForHash().delete(PERSON_KEY, id);

	}

	@Override
	public void deleteAll()
	{
		List<Person> persons = findAll();

		for (Person person : persons)
		{
			delete(person.getId());
		}

	}

	@PostConstruct
	public void setup()
	{
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer(Person.class));
	}

}
