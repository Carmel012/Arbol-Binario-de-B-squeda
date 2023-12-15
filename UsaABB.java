/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abb1;


/**
 *
 * @author carmelorodriguezchab
 */
public class UsaABB{
	
	public static void main(String[] args){
            ABB arbol = new ABB();

		//Nodo raizArbolABB = arbol.regresaRaiz();
		
		//Se insertan los valores siguiente 25, 8, 29, 38, 27
		arbol.insertarValor(25);
		arbol.insertarValor(8);
		arbol.insertarValor(29);
		arbol.insertarValor(38);
		arbol.insertarValor(27);
                
                //Buscar valor en el arbol
                int buscado = 30;
                if(arbol.buscar(buscado, arbol.regresaRaiz()))
                {
                    System.out.println("\nEl valor " + buscado + " Si esta en el arbol");// si el valor se encuentra imprimira lo sig
                }
                else
                {
                    System.out.println("\nEl valor " + buscado + " No se encuentra en el arbol");// si no, dira que no se encuentra en el arbol
                }
                
                //Se llama al metodo para recorrer el árbol de forma horizontal
		System.out.println("Arbol Horizontalmente ");
		arbol.muestraHorizontal(0, arbol.regresaRaiz());
                
                //Se llama al metodo para recorrer el árbol en preorden
                System.out.println("\nrecorrido en preorder");
                arbol.inOrden(arbol.regresaRaiz());
                
                //Se llama al metodo pararecorrer el árbol en preorder
                System.out.println("\nRecorrido preorder");
                arbol.preorder(arbol.regresaRaiz());
                
                //Se llama al metodo pararecorrer el árbol en postorden
                System.out.println("\nRecorrido postorden");
                arbol.postorden(arbol.regresaRaiz());
               
               //se llama al metodo para eliminarun nodo
                arbol.eliminar(29,arbol.regresaRaiz()); // Elimina el predecesor del valor 6 en el árbol
                System.out.println("\nSe ha eliminado el valor 29 en el árbol.");
                arbol.muestraHorizontal(0, arbol.regresaRaiz()); // Imprime el árbol horizontalmente
	}
}









