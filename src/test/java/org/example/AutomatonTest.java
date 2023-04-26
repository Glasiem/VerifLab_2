package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AutomatonTest {

    @BeforeClass
    public void setUp(){
        System.out.println("Початок тестів");
    }

    @BeforeMethod
    public void setTest(){
        System.out.println("Початок тесту");
    }

    @Test(groups = {"constructor"})
    void testConstructor(){
        Automaton automaton = new Automaton();
        assertNotNull(automaton.alphabet);
        assertNotNull(automaton.statuses);
        assertNotNull(automaton.statusFinal);

        assertTrue(automaton.alphabet.isEmpty());
        assertTrue(automaton.statuses.isEmpty());
        assertTrue(automaton.statusFinal.isEmpty());
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{3}, {4}, {5}};
    }

    @Test(groups = {"data"})
    void AutomatonTest1() throws Exception{
        Automaton automaton = new Automaton();
        automaton.setAlphabetPower(2);
        automaton.setStatusPower(3);
        automaton.setStart(0);
        automaton.setStatusFinalPower(1);
        automaton.setStatusFinal(2);
        automaton.setLink(0, 'a', 1);
        automaton.setLink(0, 'b', 2);
        automaton.setLink(1, 'a', 1);
        automaton.setLink(1, 'b', 2);
        automaton.setLink(2, 'a', 2);
        automaton.setLink(2, 'b', 1);

        assertEquals(automaton.statusFinal.size(), 1);

        automaton.proceed();
    }

    @Test(groups = {"data"})
    void AutomatonTest2() throws Exception{
        Automaton automaton = new Automaton();
        automaton.setAlphabetPower(2);
        automaton.setStatusPower(3);
        automaton.setStart(0);
        automaton.setStatusFinalPower(1);
        automaton.setStatusFinal(2);
        automaton.setLink(0, 'a', 1);
        automaton.setLink(0, 'b', 0);
        automaton.setLink(1, 'a', 1);
        automaton.setLink(1, 'b', 0);
        automaton.setLink(2, 'a', 2);
        automaton.setLink(2, 'b', 1);

        String output = automaton.proceed();

    }

    @Test(groups = {"data"}, dataProvider = "data-provider", expectedExceptions = Exception.class)
    void ExceptionTest(int state) throws Exception {
        Automaton automaton = new Automaton();
        automaton.setAlphabetPower(2);
        automaton.setStatusPower(3);
        automaton.setStart(state);
    }
}