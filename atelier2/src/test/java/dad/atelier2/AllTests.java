package dad.atelier2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dad.atelier2.carte.CarteTest;
import dad.atelier2.combinaison.CombinaisonTest;

@RunWith(Suite.class)
@SuiteClasses({ CombinaisonTest.class, CarteTest.class })
public class AllTests {

}
