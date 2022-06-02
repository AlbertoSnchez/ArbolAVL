package arbolavl;

public class Nodo {
    int clave, facDeEq;
    Nodo izq, der;

    public Nodo(int clave) {
        this.clave = clave ;
        this.facDeEq = 0;
        this.izq = null;
        this.der = null;
    }
}
