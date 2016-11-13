package dad.atelier2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dad.atelier2.carte.CarteAllTests;
import dad.atelier2.combinaison.CombinaisonTest;
import dad.atelier2.joueur.JoueurAllTests;

@RunWith(Suite.class)
@SuiteClasses({ CarteAllTests.class, JoueurAllTests.class, CombinaisonTest.class })
public class AllTests {

}
