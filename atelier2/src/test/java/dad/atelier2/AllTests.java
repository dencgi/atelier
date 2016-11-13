package dad.atelier2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dad.atelier2.carte.CarteTest;
import dad.atelier2.combinaison.CombinaisonTest;
import dad.atelier2.joueur.MainTest;

@RunWith(Suite.class)
@SuiteClasses({ CarteTest.class, MainTest.class, CombinaisonTest.class })
public class AllTests {

}
