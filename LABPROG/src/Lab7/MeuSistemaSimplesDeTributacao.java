/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import java.util.*;
public class MeuSistemaSimplesDeTributacao {
	private static boolean sair;
	private static Scanner entradaInt;
	private static Scanner entradaString;
	private static String taxista;
	private static String numeroContribuinte;
	public static void main(String args[]) throws Exception {
		entradaInt = new Scanner(System.in);
		entradaString = new Scanner(System.in);
		while (!sair) {
			System.out.println("-------- SISTEMA DE CADASTRO DE TRIBUTAÇÃO --------\n");
			System.out.println("Selecione uma das opções abaixo: ");
			System.out.println("1. Cadastrar contribuintes.");
			System.out.println("2. Calcular impostos de um determinado contribuinte.");
			System.out.println("3. Listar os contribuintes em ordem de riqueza.");
			System.out.println("4. Número de contribuintes cadastrados.");
			int opcao1 = entradaInt.nextInt();
			
			switch(opcao1) {
			case 1:
				System.out.println("Qual profissão você exerce?");
				System.out.println("1. Taxista");
				System.out.println("2. Caminhoneiro");
				System.out.println("3. Médico");
				System.out.println("4. Professor");
				int opcao2 = entradaInt.nextInt();
				cadastroContribuinte(opcao2);
				break;
			
			case 2:
				System.out.println("Qual profissão você deseja consultar?");
				System.out.println("1. Taxista");
				System.out.println("2. Caminhoneiro");
				System.out.println("3. Médico");
				System.out.println("4. Professor");
				int opcao3 = entradaInt.nextInt();
				consultaObjetosCriados(opcao3);
				break;
			
			case 3:
				exibeLimiarRiqueza();
				break;
				
			case 4:
				System.out.println("O total de contribuintes: " + Contribuintes.numeroDeContribuintes + "\n");
				break;
			}
		}
	}
	
	private static void cadastroContribuinte (int opcao) throws Exception {
		switch(opcao) {
		case 1:
			System.out.println("Digite o nome de contribuinte: ");
			String nomeContribuinte = entradaString.nextLine();
			System.out.println("Digite o número de contribuinte: ");
			String numeroContribuinte = entradaString.nextLine();
			System.out.println("Quilômetros percorridos no ano: ");
			double kmPercorridos = entradaInt.nextDouble();
			System.out.println("Passageiros transportados no ano: ");
			int passageiros = entradaInt.nextInt();
			System.out.println("Possui carro? Se sim, digite o valor. Se não, digite 0. ");
			double valorCarro = entradaInt.nextDouble();
			System.out.println("Possui casa? Se sim, digite o valor. Se não, digite 0. ");
			double valorCasa = entradaInt.nextDouble();
			new Taxistas(nomeContribuinte, numeroContribuinte, kmPercorridos, passageiros, valorCarro, valorCasa);
			System.out.println("Cadastrado com sucesso.");
			break;
		
		case 2:
			System.out.println("Digite o nome de contribuinte: ");
			String nomeContribuinte2 = entradaString.nextLine();
			System.out.println("Digite o número de contribuinte: ");
			String numeroContribuinte2 = entradaString.nextLine();
			System.out.println("Quilômetros percorridos no ano: ");
			double kmPercorridos2 = entradaInt.nextDouble();
			System.out.println("Toneladas transportadas no ano: ");
			double toneladasAno = entradaInt.nextDouble();
			System.out.println("Possui carro? Se sim, digite o valor. Se não, digite 0. ");
			double valorCarro2 = entradaInt.nextDouble();
			System.out.println("Possui casa? Se sim, digite o valor. Se não, digite 0. ");
			double valorCasa2 = entradaInt.nextDouble();
			new Caminhoneiros(nomeContribuinte2, numeroContribuinte2, kmPercorridos2, toneladasAno, valorCarro2, valorCasa2);
			System.out.println("Cadastrado com sucesso.");
			break;
		
		case 3:
			System.out.println("Digite o nome de contribuinte: ");
			String nomeContribuinte3 = entradaString.nextLine();
			System.out.println("Digite o número de contribuinte: ");
			String numeroContribuinte3 = entradaString.nextLine();
			System.out.println("Pacientes atendidos durante o ano: ");
			int pacientes = entradaInt.nextInt();
			System.out.println("Gastos em congressos durante o ano: ");
			double gastos = entradaInt.nextDouble();
			System.out.println("Possui carro? Se sim, digite o valor. Se não, digite 0. ");
			double valorCarro3 = entradaInt.nextDouble();
			System.out.println("Possui casa? Se sim, digite o valor. Se não, digite 0. ");
			double valorCasa3 = entradaInt.nextDouble();
			new Medicos(nomeContribuinte3, numeroContribuinte3, pacientes, gastos, valorCarro3, valorCasa3);
			System.out.println("Cadastrado com sucesso.");
			break;
			
		case 4:
			System.out.println("Digite o nome de contribuinte: ");
			String nomeContribuinte4 = entradaString.nextLine();
			System.out.println("Digite o número de contribuinte: ");
			String numeroContribuinte4 = entradaString.nextLine();
			System.out.println("Salário Mensal: ");
			double salario = entradaInt.nextDouble();
			System.out.println("Gastos mensais em material didático: ");
			double gastosMaterial = entradaInt.nextDouble();
			System.out.println("Possui carro? Se sim, digite o valor. Se não, digite 0. ");
			double valorCarro4 = entradaInt.nextDouble();
			System.out.println("Possui casa? Se sim, digite o valor. Se não, digite 0. ");
			double valorCasa4 = entradaInt.nextDouble();
			new Professores(nomeContribuinte4, numeroContribuinte4, salario, gastosMaterial, valorCarro4, valorCasa4);
			System.out.println("Cadastrado com sucesso.");
			break;
		}
	}
	private static void consultaObjetosCriados (int opcao){
		switch (opcao){
		case 1:
			System.out.println("Digite o nome do contribuinte taxista a ser consultado.");
			try {
			taxista = entradaString.nextLine();
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Digite o número de contribuinte taxista a ser consultado.");
			try {
			numeroContribuinte = entradaString.nextLine();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(Taxistas.consultaContribuinte(taxista, numeroContribuinte));
			break;
			
		case 2:
			System.out.println("Digite o nome do contribuinte caminhoneiro a ser consultado.");
			String caminhoneiro = entradaString.nextLine();
                        System.out.println("Digite o número do contribuinte caminhoneiro a ser consultado.");
			String numeroContribuinte2 = entradaString.nextLine();
			System.out.println(Caminhoneiros.consultaContribuinte(caminhoneiro, numeroContribuinte2));
			break;
		case 3:
			System.out.println("Digite o nome do contribuinte médico a ser consultado.");
			String medico = entradaString.nextLine();
                        System.out.println("Digite o número de contribuinte médico a ser consultado.");
			String numeroContribuinte3 = entradaString.nextLine();
			System.out.println(Medicos.consultaContribuinte(medico, numeroContribuinte3));
			break;
		case 4:
			System.out.println("Digite o nome do contribuinte professor a ser consultado.");
			String professor = entradaString.nextLine();
                        System.out.println("Digite o número de contribuinte professor a ser consultado.");
			String numeroContribuinte4 = entradaString.nextLine();
			System.out.println(Professores.consultaContribuinte(professor, numeroContribuinte4));
			break;
		}
	}
	private static void exibeLimiarRiqueza (){
		Taxistas.atualizaContribuintesLimiarRiqueza();
		Caminhoneiros.atualizaContribuintesLimiarRiqueza();
		Medicos.atualizaContribuintesLimiarRiqueza();
		Professores.atualizaContribuintesLimiarRiqueza();
		
		System.out.println("----- Contribuintes acima da limiar de riqueza -----\n");
		System.out.println("Taxistas" + " - Limiar de riqueza: " + Taxistas.getLimiarRiqueza());
		for (Taxistas a: Taxistas.getTaxistas()) {
			if (a.getAcimaDaLimiar() == true) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
		System.out.println("\nCaminhoneiros" + " - Limiar de riqueza: " + Caminhoneiros.getLimiarRiqueza());
		for (Caminhoneiros a: Caminhoneiros.getCaminhoneiros()) {
			if (a.getAcimaDaLimiar() == true) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
		System.out.println("\nMédicos" + " - Limiar de riqueza: " + Medicos.getLimiarRiqueza());
		for (Medicos a: Medicos.getMedicos()) {
			if (a.getAcimaDaLimiar() == true) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
		System.out.println("\nProfessores" + " - Limiar de riqueza: " + Professores.getLimiarRiqueza());
		for (Professores a: Professores.getProfessores()) {
			if (a.getAcimaDaLimiar() == true) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
                		System.out.println("\nCaminhoneiros: ");
		for (Caminhoneiros a: Caminhoneiros.getCaminhoneiros()) {
			if (a.getAcimaDaLimiar() == false) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
		System.out.println("\nMédicos: ");
		for (Medicos a: Medicos.getMedicos()) {
			if (a.getAcimaDaLimiar() == false) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
		System.out.println("\n----- Contribuintes abaixo da limiar de riqueza -----\n");
		System.out.println("Taxistas: ");
		for (Taxistas a: Taxistas.getTaxistas()) {
			if (a.getAcimaDaLimiar() == false) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
		System.out.println("\nProfessores: ");
		for (Professores a: Professores.getProfessores()) {
			if (a.getAcimaDaLimiar() == false) {
				System.out.println(a + " - Soma de riquezas: " + a.getSinaisRiqueza());
			}
		}
	}
}

