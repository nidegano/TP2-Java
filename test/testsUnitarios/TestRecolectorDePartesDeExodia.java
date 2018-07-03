package testsUnitarios;

import org.junit.Test;

import cartas.BrazoDerechoExodia;
import cartas.BrazoIzquierdoExodia;
import cartas.CabezaExodia;
import cartas.PiernaDerechaExodia;
import cartas.PiernaIzquierdaExodia;
import excepciones.TengoTodasLasPartesDeExodiaException;
import juego.RecolectorDePartesDeExodia;

public class TestRecolectorDePartesDeExodia {
	
	@Test(expected = TengoTodasLasPartesDeExodiaException.class)
	public void TestRecolectoTodasLasPartesDeExodiaDevuelveLaExceptionTengoTodasLasPartesDeExodia() {
		RecolectorDePartesDeExodia recolector = new RecolectorDePartesDeExodia();
		
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new BrazoDerechoExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new BrazoIzquierdoExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaDerechaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaIzquierdaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new CabezaExodia());
	}
	
	

}
