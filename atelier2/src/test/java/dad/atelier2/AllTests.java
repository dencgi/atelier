package dad.atelier2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dad.atelier2.carte.CarteTest;
import dad.atelier2.main.MainTest;

@RunWith(Suite.class)
@SuiteClasses({ MainTest.class, CarteTest.class })
public class AllTests {

}
