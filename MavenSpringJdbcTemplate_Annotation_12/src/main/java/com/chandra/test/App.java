package com.chandra.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.chandra.bean.Person;
import com.chandra.configuration.ApplicationConfig;
import com.chandra.services.PersonService;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PersonService personService = (PersonService) context.getBean("personService");
		Person bharath = new Person(3, "Bharath", "D", 22);
		Person charan = new Person(4, "Charan", "B", 21);
		Person vishal = new Person(5, "Vishal", "Naik", 40);

		personService.addPerson(bharath);
		personService.addPerson(charan);
		personService.addPerson(vishal);
		
		System.out.println("Find All");
        List < Person > persons = personService.findAll();
        for (Person person: persons) {
            System.out.println(person);
        }
        
        System.out.println("Delete person Id = 2");
        int deleteMe = 2;
        personService.deletePerson(deleteMe);
        
        vishal.setFirstName("Yashwant - Updated");
        vishal.setLastName("Chavan - Updated");
        vishal.setAge(40);
 
        System.out.println("Update person Id = 1");
        int updateMe = 1;
        personService.editPerson(vishal, updateMe);
        
        System.out.println("Find person Id = 4");
        Person person = personService.find(4);
        System.out.println(person);

	}

}
