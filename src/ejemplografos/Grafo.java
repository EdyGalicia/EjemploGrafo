
package ejemplografos;

import java.util.LinkedList;

public class Grafo {
    LinkedList<Vertice> vertices;

    public Grafo() {
        this.vertices = new LinkedList<>();
    }
    
    public void addVertice(int i){
        Vertice a = existe(i);
        if (a != null) {
            System.out.println("Ya existe el vertice");
            return;
        }
        this.vertices.add(new Vertice(i));
        System.out.println("Ya se agrego el vertice.");
    }
    
    public void enlazar(int a, int b){
        Vertice origen, destino;
        origen = existe(a);
        destino = existe(b);
        if (origen == null || destino == null) {
            System.out.println("Error al enlazar, no se encontro el origen o destino");
            return;
        }
        //hacemos las aristas, estas como no son dirigidas, se enlazan en los dos sentidos
        origen.getAdyacentes().add(destino);
        destino.getAdyacentes().add(origen);
    }
    
    //ANCHURA, nodos aleda;os de cierto vertice
    public void BFS(){
        //aqui vamos a guardar los nodos en los que ya ingresamos
        LinkedList<Vertice> aux = new LinkedList<>();
        
        //recorremos el grafo
        for(Vertice a : this.vertices){
            //si no lo contiene, lo agregamos
            if (aux.contains(a) == false) {
                aux.add(a);
            }
            
            //recorremos la lista de adyacentes y metemos a nuestro aux si no estan agregados
            for(Vertice b: a.getAdyacentes()){
                if (aux.contains(b)) {
                    //  
                }else{
                    aux.add(b);
                }
            }
        }
        
        //ahora que ya tenemos un camino despues de recorrer todos los nodos
        while(!aux.isEmpty()){
            System.out.println(aux.poll().getNumero());
        }
    }
    
    //PROFUNDIDAD, se va metiendo y cuando ya no puede mas, se va regresando y buscando otros caminos
    public void DFS(){
        LinkedList<Vertice> aux = new LinkedList<>();
        for(Vertice e: this.vertices){
            DFS(aux, e);
        }
        while(!aux.isEmpty()){
            System.out.println(aux.poll().getNumero());
        }
    }
    
    private void DFS(LinkedList<Vertice> aux, Vertice actual){
        //si no lo contiene, quiere decir que no hemos pasado por alli
        if (!aux.contains(actual)) {
            aux.add(actual);
        }else{
            return;
        }
        for(Vertice a: actual.getAdyacentes()){
            DFS(aux,a);
        }
    }
    
    //busca el vertice y nos lo retorna si lo encuentra
    public Vertice existe(int i){
        for(Vertice e: this.vertices){
            if (e.getNumero() == i) {
                return e;
            }
        }
        return null;
    }
    
    public void dibujar(){
        LinkedList<Vertice> aux = new LinkedList<>();
        StringBuilder sc = new StringBuilder();
        sc.append("digraph G{\n");
        for (int i = 0; i < this.vertices.size(); i++) {
            Vertice temp = this.vertices.get(i);
            if (aux.contains(temp) == false) {
                aux.add(temp);
                sc.append("node").append(temp.hashCode()).append(" [label=\"").append(temp.getNumero()).append("\"];\n");
            }
            for (int j = 0; j < temp.getAdyacentes().size(); j++) {
                sc.append("node").append(temp.hashCode()).append("->node").append(temp.getAdyacentes().get(j).hashCode()).append(";\n");
                if (aux.contains(temp.getAdyacentes().get(j))) {
                    //no se hace nada
                }else{
                    aux.add(temp.getAdyacentes().get(j));
                    sc.append("node").append(temp.getAdyacentes().get(j).hashCode()).append(" [label=\"").append(temp.getAdyacentes().get(j).getNumero()).append("\"];\n");
                }

            }
        }
        sc.append("}");
        System.out.println(sc.toString());
    }
    
}
