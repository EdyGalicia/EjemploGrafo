
package ejemplografos;

import java.util.LinkedList;


public class Vertice {
    private int numero;
    //lista de nodos adyacentes
    private LinkedList<Vertice> adyacentes;

    public Vertice(int numero) {
        this.numero = numero;
        this.adyacentes = new LinkedList<>();
    }
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the adyacentes
     */
    public LinkedList<Vertice> getAdyacentes() {
        return adyacentes;
    }

    /**
     * @param adyacentes the adyacentes to set
     */
    public void setAdyacentes(LinkedList<Vertice> adyacentes) {
        this.adyacentes = adyacentes;
    }
    
}
