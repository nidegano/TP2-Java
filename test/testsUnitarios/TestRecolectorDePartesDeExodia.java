package testsUnitarios;

import org.junit.Test;

import cartas.BrazoDerechoExodia;
import cartas.BrazoIzquierdoExodia;
import cartas.CabezaExodia;
import cartas.InsectoComeHombres;
import cartas.OllaDeLaCodicia;
import cartas.PiernaDerechaExodia;
import cartas.PiernaIzquierdaExodia;
import excepciones.TengoTodasLasPartesDeExodiaException;
import juego.RecolectorDePartesDeExodia;

public class TestRecolectorDePartesDeExodia {
	
	@Test(expected = TengoTodasLasPartesDeExodiaException.class)
	public void testRecolectoTodasLasPartesDeExodiaDevuelveLaExceptionTengoTodasLasPartesDeExodia() {
		RecolectorDePartesDeExodia recolector = new RecolectorDePartesDeExodia();
		
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new BrazoDerechoExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new BrazoIzquierdoExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaDerechaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaIzquierdaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new CabezaExodia());
	}
	
	@Test
	public void testSiNoSonLasPartesDeExodiaNoLanzaNingunaExepcion() {
        RecolectorDePartesDeExodia recolector = new RecolectorDePartesDeExodia();
		
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new InsectoComeHombres());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new OllaDeLaCodicia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaDerechaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaIzquierdaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new CabezaExodia());
	}
	
	@Test
	public void testSiSonPartesDeExodiaRepetidasNoLanzaNingunaExepcion() {
        RecolectorDePartesDeExodia recolector = new RecolectorDePartesDeExodia();
		
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaIzquierdaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaDerechaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaDerechaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new PiernaIzquierdaExodia());
		recolector.siEsUnaParteDelExodiaQueNoTeniaRecolectar(new CabezaExodia());
	}
	
	

}
