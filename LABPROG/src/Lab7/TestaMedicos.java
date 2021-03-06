/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import org.junit.*;
public class TestaMedicos {
    private Medicos med1, med2, med3;
	private final int NAO_TEM_CARRO = 0, NAO_TEM_CASA = 0;
	private final double VALOR_PADRAO_CASA = 50000, VALOR_PADRAO_CARRO = 20000, VALOR_ACIMA_CASA = 800000, VALOR_ACIMA_CARRO = 200000;
	private final int PACIENTES1 = 2500, PACIENTES2 = 10000, PACIENTES3 = 8000;
	private final double GASTOS_CONGRESSOS1 = 7000, GASTOS_CONGRESSOS2 = 15000, GASTOS_CONGRESSOS3 = 43440;
	
	@Before
	public void criaObjetos () throws Exception {
		med1 = new Medicos("Andécio", "12345", PACIENTES1, GASTOS_CONGRESSOS1, NAO_TEM_CARRO, NAO_TEM_CASA);
		med2 = new Medicos("Kelvin", "91234", PACIENTES2, GASTOS_CONGRESSOS2, VALOR_ACIMA_CARRO, VALOR_ACIMA_CASA);
		med3 = new Medicos("Daniel", "81329", PACIENTES3, GASTOS_CONGRESSOS3, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
	}
	
	@Test
	public void testaConstrutor () {
		try {
			new Medicos("Andécio", "123-4", -1, GASTOS_CONGRESSOS1, NAO_TEM_CARRO, NAO_TEM_CASA);
			Assert.fail("Deve lançar exceção porque os pacientes não podem ser negativos.");
		} catch (Exception e) {
			Assert.assertEquals("O valor dos gastos e pacientes não podem ser negativos.", e.getMessage());
		}
		
		try {
			new Medicos("Andécio", "123-4", PACIENTES1, -1, NAO_TEM_CARRO, NAO_TEM_CASA);
			Assert.fail("Deve lançar exceção porque os pacientes não podem ser negativos.");
		} catch (Exception e) {
			Assert.assertEquals("O valor dos gastos e pacientes não podem ser negativos.", e.getMessage());
		}
		
		Assert.assertEquals("Daniel", med1.getNomeContribuinte());
		Assert.assertEquals("12345", med1.getNumeroContribuinte());
		Assert.assertEquals(NAO_TEM_CARRO, med1.getValorcarro(), 0.1);
		Assert.assertEquals(NAO_TEM_CASA, med1.getValorcasa(), 0.1);
		Assert.assertEquals(VALOR_ACIMA_CARRO, med2.getValorcarro(), 0.1);
		Assert.assertEquals(VALOR_ACIMA_CASA, med2.getValorcasa(), 0.1);
		Assert.assertEquals(VALOR_PADRAO_CARRO, med3.getValorcarro(), 0.1);
		Assert.assertEquals(VALOR_PADRAO_CASA, med3.getValorcasa(), 0.1);
		Assert.assertEquals(3, Medicos.getNumeroDeMedicos());
	}
	
	@Test
	public void testaCalculaTributacao () {
		Assert.assertEquals(25000, med1.getTributacao(), 1);
		Assert.assertEquals(100000, med2.getTributacao(), 1);
		Assert.assertEquals(80000, med3.getTributacao(), 1);
	}
	
	@Test
	public void testaDescontoTributacao () {
		Assert.assertEquals(7000, med1.getDescontos(), 1);
		Assert.assertEquals(15000, med2.getDescontos(), 1);
		Assert.assertEquals(43440, med3.getDescontos(), 0.01);
	}
	
	@Test
	public void testaTributacaoTotal () {
		Assert.assertEquals(18000, med1.getTributacaoTotal(), 1);
		Assert.assertEquals(85000, med2.getTributacaoTotal(), 1);
		Assert.assertEquals(36560, med3.getTributacaoTotal(), 0.01);
	}
	
	@Test
	public void testaLimiarRiqueza () throws Exception {
		Medicos.atualizaContribuintesLimiarRiqueza();
		Assert.assertFalse(Medicos.getMedicos().get(0).getAcimaDaLimiar());
		Assert.assertTrue(Medicos.getMedicos().get(1).getAcimaDaLimiar());
		Assert.assertFalse(Medicos.getMedicos().get(2).getAcimaDaLimiar());
		}
	
	@Test
	public void testaToString () {
		Assert.assertEquals("Nome: Daniel - Número de contribuinte: 12345", med1.toString());
		Assert.assertEquals("Nome: Kelvink - Número de contribuinte: 91234", med2.toString());
		Assert.assertEquals("Nome: Andécio - Número de contribuinte: 81329", med3.toString());
	}
	
	@Test
	public void testaEquals () throws Exception {
		Taxistas taxi = new Taxistas("Teste", "1234", 20, 20, NAO_TEM_CARRO, NAO_TEM_CASA);
		Assert.assertFalse(med1.equals(taxi));
		Assert.assertFalse(med1.equals(med2));
		Assert.assertFalse(med2.equals(med3));
		med1 = new Medicos("Kelvin", "91234", PACIENTES2, GASTOS_CONGRESSOS2, VALOR_ACIMA_CARRO, VALOR_ACIMA_CASA);
		Assert.assertTrue(med1.equals(med2));
	} 
}
