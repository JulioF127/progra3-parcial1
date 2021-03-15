package com.umg.parcial;
import java.util.Scanner;

public class Arboles {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		ArbolBinario bt = new ArbolBinario();
		
		int opcion = 0;
		System.out.println("1. MOSTRAR");
		System.out.println("2. GUARDAR");
		System.out.println("0. SALIR");
		do {
			System.out.println("INGRESE OPCION");
			opcion = sc.nextInt();
			if (opcion == 1) {

				ArbolBinario.mostrar(ArbolBinario.raiz);
			}else if (opcion == 2) {
				int dato;
				System.out.println("INGRESE VALOR");
				dato = sc.nextInt();
				System.out.println("guardar "+dato);
				ArbolBinario.agregar(dato);
			}
			
		}while(opcion>0);
		System.out.println("FIN");
		
	}

}

class ArbolBinario {
	static Nodo raiz;
	
	public ArbolBinario() {
		Nodo nodo2 = new Nodo(2,null,null);
		Nodo nodo5 = new Nodo(5,null,null);
		Nodo nodo4 = new Nodo(4,nodo2,nodo5);
		Nodo nodo9 = new Nodo(9,null,null);
		Nodo nodo7 = new Nodo(7,null,null);
		Nodo nodo8 = new Nodo(8,nodo7,nodo9);
		raiz = new Nodo(6,nodo4,nodo8);
	}

	

	public static void agregar(int valor) {
		Nodo nodoN = new Nodo(valor,null,null);
		Nodo auxiliar = raiz;
		Nodo padre;
		while(true)
		{
			padre = auxiliar;
			if (valor < auxiliar.value)
			{
				auxiliar = auxiliar.getIzq();
				if (auxiliar == null){
					padre.setIzq(nodoN);
					return;
				}
			}
			else
			{
				auxiliar = auxiliar.getDer();
				if (auxiliar == null)
				{
					padre.setDer(nodoN);
					return;
				}
			}
		}

	}
	
	
	
	public static void mostrar(Nodo raiz) {
		if (raiz!=null)
		{
			System.out.println(raiz.value);
			mostrar(raiz.getIzq());
			mostrar(raiz.getDer());
		}

	}
}

class Nodo{
	//NO MODIFICAR
	int value;
	private Nodo izq;
	private Nodo der;
	private Nodo actual;
	public Nodo(int value, Nodo izq, Nodo der) {
		this.value = value;
		this.izq = izq;
		this.der = der;
	}
	public Nodo(int value) {
		System.out.println("guardar "+value);
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Nodo getIzq() {		
		return izq;
	}
	public void setIzq(Nodo izq) {
		this.izq = izq;
	}
	public Nodo getDer() {
		
		return der;
	}
	public void setDer(Nodo der) {		
		this.der = der;
	}
	
}