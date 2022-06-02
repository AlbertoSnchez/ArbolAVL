package arbolavl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        Scanner leer = new Scanner(System.in);  
        int dato, opc, opcrec;      
        do {
            
            System.out.println("\n-----Seleccione una opcion-----");
            System.out.println("1)Insertar elementos\n2)Recorridos\n3)Salir");
            opc=leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Ingrese la clave del nodo a insertar: ");
                    dato = leer.nextInt();
                    arbol.insert(dato);
                    break;
                case 2:
                    System.out.println("Seleccione el recorrido que desea ejecutar");
                    System.out.println("1)Inorden\n2)Preorden\n3)Postorden");
                    opcrec = leer.nextInt();
                    switch (opcrec) {
                        case 1:
                            arbol.Inorden(arbol.raiz);
                            break;
                        case 2:
                            arbol.Preorden(arbol.raiz);
                            break;
                        case 3:
                            arbol.Postorden(arbol.raiz);
                            break;
                        default:
                            System.out.println("No valido");
                    }
                    break;
                case 3:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("No valida");
            }
        arbol.imp(arbol.raiz,0);
        } while (opc != 3);
    }
}
