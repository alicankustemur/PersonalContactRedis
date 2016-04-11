package com.tr.t2.personalcontact.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:test-config.xml"})
public class PersonControllerTest
{
	@Autowired
	protected WebApplicationContext	wac;

	private MockMvc					mockMvc;

	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testPageLoad() throws Exception
	{
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
	}

	@Test
	public void TestAddPersonRedirectWhenClickSaveButton() throws Exception
	{
		mockMvc.perform(post("/addPerson")).andExpect(status().is3xxRedirection());

	}

	@Test
	public void TestDeletePersonRedirectWhenClickDeleteButton() throws Exception
	{
		mockMvc.perform(get("/deletePerson?id=0")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void TestUpdatePersonRedirectWhenClickSaveButton() throws Exception
	{
		mockMvc.perform(get("/updatePerson?id=0")).andExpect(status().isOk());

	}

}
