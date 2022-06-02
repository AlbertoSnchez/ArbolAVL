package arbolavl;

public class ArbolAVL {
    Nodo raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
    public int getfacDeEq(Nodo fac){
        if(fac == null)
            return -1;
        else
            return fac.facDeEq;
    }
    
    public Nodo II(Nodo nodo){
        Nodo aux = nodo.izq;
        nodo.izq=aux.der;
        int fde1= getfacDeEq(nodo.der), fde2 = getfacDeEq(nodo.izq);
        if(fde1 > fde2)
            nodo.facDeEq = fde1+1;
        else
            nodo.facDeEq = fde2+1;
        aux.der=nodo;
        fde1= getfacDeEq(aux.der);
        fde2 = getfacDeEq(aux.izq);
        if(fde1 > fde2)
            aux.facDeEq = fde1+1;
        else
            aux.facDeEq = fde2+1;
        return aux;              
    }
    
    public Nodo DD(Nodo nodo){
        Nodo aux = nodo.der;
        nodo.der=aux.izq;
        int fde1= getfacDeEq(nodo.der), fde2 = getfacDeEq(nodo.izq);
        if(fde1 > fde2)
            nodo.facDeEq = fde1+1;
        else
            nodo.facDeEq = fde2+1;
        aux.izq=nodo;
        fde1= getfacDeEq(aux.der);
        fde2 = getfacDeEq(aux.izq);
        if(fde1 > fde2)
            aux.facDeEq = fde1+1;
        else
            aux.facDeEq = fde2+1;
        return aux;              
    }
    
     public Nodo DI(Nodo nodo){
        nodo.der = II(nodo.der);
        Nodo aux=DD(nodo);
        return aux;
    }
    
    public Nodo ID(Nodo nodo){
        nodo.izq = DD(nodo.izq);
        Nodo aux=II(nodo);
        return aux;
    }
    
    public Nodo insertar(Nodo hoja, Nodo rama){
        Nodo aux=rama;
        if(hoja.clave < rama.clave){
            if(rama.izq == null)
                rama.izq = hoja;
            else{
                rama.izq=insertar(hoja,rama.izq);
                if((getfacDeEq(rama.der) - getfacDeEq(rama.izq)) == -2){
                    System.out.println("Desequilibrio en el nodo " + rama.clave + ", factor de equilibrio -2");
                    if(hoja.clave < rama.izq.clave){
                        System.out.println("Se aplicará una rotación II patra solucionar el desequilibrio");
                        aux=II(rama);
                    } else{
                        System.out.println("Se aplicará una rotación ID patra solucionar el desequilibrio");
                        aux=ID(rama);
                    }   
                }
            }
        } else if(hoja.clave>rama.clave){
            if(rama.der == null)
                rama.der = hoja;
            else{
                rama.der=insertar(hoja, rama.der);
                if((getfacDeEq(rama.der)-getfacDeEq(rama.izq)) == 2){
                    System.out.println("Desequilibrio en el nodo " + rama.clave + ", factor de equilibrio 2");
                    if(hoja.clave > rama.der.clave){
                        System.out.println("Se aplicará una rotación DD patra solucionar el desequilibrio");
                        aux = DD(rama);
                    }else{
                        System.out.println("Se aplicará una rotación DI patra solucionar el desequilibrio");
                        aux = DI(rama);
                    }
                }
            }
        } else
            System.out.println("Nodo previamente insertado");
        if((rama.izq ==  null) && (rama.der != null))
            rama.facDeEq=rama.der.facDeEq+1;
        else if((rama.der ==  null) && (rama.izq != null))
            rama.facDeEq=rama.izq.facDeEq+1;
        else{
            int fde1= getfacDeEq(rama.der), fde2 = getfacDeEq(rama.izq);
            if(fde1 > fde2)
                rama.facDeEq = fde1+1;
            else
                rama.facDeEq = fde2+1;
        }
        return aux;
    }
    
    public void insert(int clave){
        Nodo aux = new Nodo(clave);
        if(raiz == null)
            raiz = aux;
        else
            raiz=insertar(aux,raiz);
    }
    
    public void Inorden(Nodo ar){
        if(ar != null){
            Inorden(ar.izq);
            System.out.print(ar.clave + "-");
            Inorden(ar.der);
        }
    }
    
    public void Preorden(Nodo ar){
        if(ar != null){
            System.out.print(ar.clave + "-");
            Preorden(ar.izq);
            Preorden(ar.der);
        }
    }
    
    public void Postorden(Nodo ar){
        if(ar != null){
            Postorden(ar.izq);
            Postorden(ar.der);
            System.out.print(ar.clave + "-");
        }
    }
    
    public void imp(Nodo ar, int aux){
        if (ar == null) 
            return;
        else{
            aux += 1;
            imp(ar.der,aux);
            for (int i = 0; i < aux; i++) {
                System.out.print("   ");
            }
            System.out.println(ar.clave + "\n");
            imp(ar.izq,aux);
        }
    }
}


