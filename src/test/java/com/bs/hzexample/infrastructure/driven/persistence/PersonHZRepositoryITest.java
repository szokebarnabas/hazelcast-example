package com.bs.hzexample.infrastructure.driven.persistence;

import com.bs.hzexample.config.HZConfig;
import com.bs.hzexample.domain.person.Email;
import com.bs.hzexample.domain.person.Person;
import com.bs.hzexample.domain.person.PersonId;
import com.bs.hzexample.domain.person.PersonRepository;
import com.bs.hzexample.infrastructure.driven.PersonFixture;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HZConfig.class})
public class PersonHZRepositoryITest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void saveStoresDomainObject() throws Exception {
        //setup
        personRepository.removeAll();
        Person person = PersonFixture.getPerson(PersonId.createFrom("PERSON_1"));

        //act
        personRepository.save(person);

        //assert
        Person foundPerson = personRepository.find(person.getID());
        assertThat(foundPerson, Matchers.equalTo(person));
    }

    @Test
    public void findReturnsDomainObject() {
        //setup
        personRepository.removeAll();
        Person person = PersonFixture.getPerson(PersonId.createFrom("PERSON_2"));
        personRepository.save(person);

        //act
        Person result = personRepository.find(person.getID());

        //assert
        assertThat(result, Matchers.equalTo(person));
    }

    @Test
    public void findAllReturnsAllOfThePeople() throws Exception {
        //setup
        personRepository.removeAll();
        Person person1 = PersonFixture.getPerson(PersonId.createFrom("PERSON_1"));
        Person person2 = PersonFixture.getPerson(PersonId.createFrom("PERSON_2"));
        personRepository.save(person1);
        personRepository.save(person2);

        //act
        Collection<Person> result = personRepository.findAll();

        //assert
        assertEquals(2, result.size());
        assertThat(result, Matchers.hasItems(person1, person2));
    }

    @Test
    public void updateChangesTheEmailAddress() {
        //setup
        personRepository.removeAll();
        Person person = PersonFixture.getPerson(PersonId.createFrom("PERSON_3"));
        personRepository.save(person);
        Email newEmail = Email.createEmail("foo@bar.com");
        person.changeEmail(newEmail);

        //act
        personRepository.update(person);

        //assert
        Person updatedPerson = personRepository.find(person.getID());
        assertThat(updatedPerson.getEmail(), Matchers.equalTo(newEmail));
    }

    @Test
    public void removeDeletesPerson() {
        //setup
        personRepository.removeAll();
        Person person = PersonFixture.getPerson(PersonId.createFrom("PERSON_4"));
        personRepository.save(person);

        //act
        personRepository.remove(person.getID());

        //assert
        Collection<Person> people = personRepository.findAll();
        assertEquals(0, people.size());
    }

}