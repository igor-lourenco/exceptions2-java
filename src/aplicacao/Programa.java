package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entitidades.Conta;
import exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta ");
		System.out.print("Conta: ");
		int numero = sc.nextInt();
		System.out.print("Cliente: ");
		sc.nextLine();
		String cliente = sc.nextLine();
		System.out.print("Saldo inicial: ");
		Double saldo = sc.nextDouble();
		System.out.print("Limite de retirada: ");
		Double limite = sc.nextDouble();
		
		Conta conta = new Conta(numero, cliente, saldo, limite);
		
		System.out.println();
		System.out.print("Quantos deseja sacar: ");
		Double montante = sc.nextDouble();
		
		try {
		conta.saque(montante);
		System.out.println("Saldo restante: " + String.format("%.2f", conta.getSaldo()));
		}
		catch(DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();

	}

}
