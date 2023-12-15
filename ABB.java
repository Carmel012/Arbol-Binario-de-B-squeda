/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.abb1;

/**
 *
 * @author carmelorodriguezchab
 */
public class ABB{   		
	Nodo raiz;  //se asigna el puntero tipo Nodo

	ABB(){
        this.raiz = null;//Se encarga en inicializar la raiz en null
	} 
        
	public boolean esVacio(){
            return (this.raiz == null); //Este metodo sirve para saber si esta vacio el arbol
	}

	public Nodo regresaRaiz(){   //getRaiz  -- getter de atributo raiz
            return this.raiz;
	}

	public void insertarValor(int valor){
          if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
		}
          
            else insertarNodo(valor, this.raiz);
	}

	public void insertarNodo(int valor, Nodo nodoRef){
          if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);//se inserta el nombre del nodo referenciado y su valor
                nodoRef.izquierdo =  new Nodo(); //crea un nuevo nodo
                nodoRef.izquierdo.dato = valor; // Asigna el valor al nodo izquierdo
                nodoRef.izquierdo.izquierdo = null;// Inicializa el subárbol izquierdo del nodo izquierdo como nulo 
                nodoRef.izquierdo.derecho = null;// Inicializa el subárbol derecho del nodo izquierdo como nulo
	}
        else{
            insertarNodo(valor, nodoRef.izquierdo);// Llama recursivamente al método insertarNodo para insertar el valor en el subárbol izquierdo
            }
            }
	else {
            if (valor > nodoRef.dato)//si valor es mayor al valor del nodo
             {
            if (nodoRef.derecho == null)
                {
            System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);//se inserta el nombre del nodo referenciado y su valor
            nodoRef.derecho =  new Nodo();//crea un nuevo nodo
            nodoRef.derecho.dato = valor;// Asigna el valor al nodo derecho
            nodoRef.derecho.izquierdo = null;// Inicializa el subárbol izquierdo del nodo derecho como nulo
            nodoRef.derecho.derecho = null;// Inicializa el subárbol derecho del nodo derecho como nulo
            }
        else {
            insertarNodo(valor, nodoRef.derecho);// Llama recursivamente al método insertarNodo para insertar el valor en el subárbol derecho
		}
            }
	}
}


	public void muestraHorizontal(int nivel, Nodo nodoRef)
        {
            if (nodoRef == null){
		return;
            }
            else {
            muestraHorizontal(nivel + 1, nodoRef.derecho);// Llama recursivamente al método arbolHorizontal para imprimir el subárbol derecho

		for (int i=0; i < nivel; i++)
                {
		System.out.print("     ");//imprime espacios vacios para que se logre distinguir
                }

                System.out.println("[" + nodoRef.dato + "]<");// imprime el valor del nodo actual
		muestraHorizontal(nivel + 1, nodoRef.izquierdo);
		}
	}
        
    public boolean buscar(int x, Nodo nodoRef){
        if(nodoRef == null){
           return false;
        }
        
        else if (x < nodoRef.dato) {
           return this.buscar(x, nodoRef.izquierdo);// Llama recursivamente al método busqueda para buscar el valor en el subárbol izquierdo
        }
        
        else {
            return x > nodoRef.dato ? this.buscar(x, nodoRef.derecho): true;// Llama recursivamente al método busqueda para buscar el valor en el subárbol derecho
        }
    }
    
    //Metodo para imprimir el arbol en inOrden
    //regla del inorden izq, raíz, der
    public void inOrden(Nodo nodoRef){
        if (nodoRef == null){ 
            return;
            }
                
        inOrden(nodoRef.izquierdo);//Llama recursivamente al método inOrden para recorrer el subárbol izquierdo 
        System.out.print("[" + nodoRef.dato + "]" + " - ");//Imprime el valor del nodo actual
        inOrden(nodoRef.derecho);  //Llama recursivamente al método inOrden para recorrer el subárbol derecho    
        
    }   
    
    //Metodo para imprimir el arbol en preorder
    //regla del preorder raiz, izq, der
    public void preorder(Nodo nodoRef){
        if (nodoRef == null){
            return;
        }
        System.out.print("[" + nodoRef.dato + "]" + " - ");//Imprimi el valor del nodo actual
        preorder(nodoRef.izquierdo);//llama recursivamente al metodo preorder para recorrer el arbol de manera izquierda
        preorder(nodoRef.derecho);//llama recursivamente al metodo preorder para recorrer el arbol de manera izquierda
        }
    
    //Metodo para imprimir el arbol en postorden
    //regla del preorder izq, der, raiz
    public void postorden(Nodo nodoRef){
        if(nodoRef == null){
            return;
        }
        postorden(nodoRef.izquierdo);//llama recursivamente al metodo postorden para recorrer el arbol de manera izquierda
        postorden(nodoRef.derecho);//llama recursivamente al metodo postorden para recorrer el arbol de manera derecho
        System.out.print("[" + nodoRef.dato + "]" + " - "); //Imprimi el valor del nodo actual
    }
    
        /**
     * Busca el nodo con el valor mayor en el ABB.
     * @return el nodo con el valor mayor.
     */
    public Nodo buscaMayor(Nodo nodoRef) 
    {
        if (nodoRef == null) 
        {
            return null;
        } 
        else 
        {
            if (nodoRef.derecho == null)
            {
                return nodoRef; // Retorna el nodo actual si no tiene subárbol derecho
            }
            else
            {
                return buscaMayor(nodoRef.derecho); // Llama recursivamente al método buscaMayor para buscar el nodo con el valor mayor en el subárbol derecho
            }
        }
    }

    
    public void eliminar(int x, Nodo nodoRef) {
        if (nodoRef == null)
        {
            return;
        } 
        else
        {
            if (x < nodoRef.dato)
            {
                eliminar(x, nodoRef.izquierdo); // Llama recursivamente al método eliminarPredecesor para eliminar el nodo predecesor en el subárbol izquierdo
            }
            else
            {
                if (x > nodoRef.dato)
                {
                    eliminar(x, nodoRef.derecho); // Llama recursivamente al método eliminarPredecesor para eliminar el nodo predecesor en el subárbol derecho
                }
                else
                {
                    if (nodoRef.izquierdo != null && nodoRef.derecho != null)
                    {
                        Nodo mayor = buscaMayor(nodoRef.izquierdo); // Busca el nodo con el valor mayor en el subárbol izquierdo
                        nodoRef.dato = mayor.dato; // Asigna el valor del nodo mayor al nodo actual
                        eliminar(mayor.dato, nodoRef.izquierdo); // Llama recursivamente al método eliminarPredecesor para eliminar el nodo mayor en el subárbol
                    }
                    else
                    {
                        if (nodoRef.izquierdo == null)
                        {
                            nodoRef = nodoRef.derecho; // Asigna el subárbol derecho al nodo actual
                        }
                        else
                        {
                            if (nodoRef.derecho == null)
                            {
                                nodoRef = nodoRef.izquierdo; // Asigna el subárbol izquierdo al nodo actual
                            }
                        }
                    }
                }
            }
        }
    }
}










