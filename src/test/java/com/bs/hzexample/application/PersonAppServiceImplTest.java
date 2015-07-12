package com.bs.hzexample.application;

import com.bs.hzexample.domain.person.Person;
import com.bs.hzexample.domain.person.PersonId;
import com.bs.hzexample.domain.person.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PersonAppServiceImplTest {

    private PersonAppService testObj;
    @Mock
    private PersonRepository personRepository;

    @Before
    public void setup() {
        testObj = new PersonAppServiceImpl(personRepository);
    }

    @Test
    public void addPersonSuccessfullySavesPerson() {
        //setup
        Person person = mock(Person.class);

        //act
        testObj.addPerson(person);

        //assert
        verify(personRepository).save(person);
    }


    @Test
    public void findPersonReturnsPerson() {
        //setup
        PersonId personID = mock(PersonId.class);

        //act
        testObj.findPerson(personID);

        //assert
        verify(personRepository).find(personID);
    }
}