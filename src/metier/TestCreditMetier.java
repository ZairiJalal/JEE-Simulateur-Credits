package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCreditMetier {
	
	CreditMetier creditMetier;

	@Before
	public void setUp() throws Exception {
		creditMetier = new CreditMetierImpl();
	}

	@Test
	public void testCalculMensualite() {
		double resultaAttendu = 17.1031;
		double resultaObtenu = creditMetier.calculMensualite(200, 4.8, 12);
		assertEquals(resultaAttendu, resultaObtenu, 0.0001);
	}

}
