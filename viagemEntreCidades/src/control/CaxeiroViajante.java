package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaxeiroViajante {

	public static void main(String[] args) {
		
		int n = 4;
		int[][] m = matriz(n, 100);
		
		imprimir(n, m);
		
		List<Integer> cidades = new ArrayList<>();
		
		for(int i = 1; i < n; i++) {
			
			cidades.add(i);
			
		}
		
		int menorCaminho = Integer.MAX_VALUE;
		List<Integer> melhorRota = null;
		
		for(List<Integer> p : permutar(cidades)) {
			
			int rotaAtual = 0;
			int k = 0;
			
			for(int i : p) {
				
				rotaAtual += m[k][i];
				k = i;
				
			}
			
			rotaAtual += m[k][0];
			
			if(rotaAtual < menorCaminho) {
				
				menorCaminho = rotaAtual;
				melhorRota = new ArrayList<>(p);
				
			}
			
		}
		
		System.out.println();
		System.out.print("Menor distância: " + menorCaminho + ".");
		System.out.println();
		System.out.print("Melhor rota: A -> ");
		
		for(int c : melhorRota) {
			
			System.out.print((char)('A' + c) + " -> ");
			
		}
		
		System.out.println("A.");

	}
	
	public static List<List<Integer>> permutar(List<Integer> lista){
		
		List<List<Integer>> resultado = new ArrayList<>();
		
		voltar(resultado, new ArrayList<>(), lista);
		
		return resultado;
		
	}
	
	public static void voltar(List<List<Integer>> resultado, List<Integer> temp, List<Integer> lista) {
		
		if(temp.size() == lista.size()) {
			
			resultado.add(new ArrayList<>(temp));
			
		} else {
			
			for(int i = 0; i < lista.size(); i++) {
				
				if(temp.contains(lista.get(i))) continue;
				temp.add(lista.get(i));
				voltar(resultado, temp, lista);
				temp.remove(temp.size() - 1);
				
			}
			
		}
		
	}
	
	public static int[][] matriz(int n, int max){
		
		Random r = new Random();
		int[][] m = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				if(i == j) {
					
					m[i][j] = 0;
					
				} else {
					
					m[i][j] = r.nextInt(max + 1);
					m[j][i] = m[i][j];
					
				}
				
			}
			
		}
		
		return m;
	
	}
	
	public static void imprimir(int n, int[][] m) {
		
		System.out.println("Matriz das distâncias: ");
		System.out.println();
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				System.out.printf("%4d", m[i][j]);
				
			}
			
			System.out.println();
			
		}
	
	}

}
