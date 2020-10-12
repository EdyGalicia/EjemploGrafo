
package ejemplografos;


public class EjemploGrafos {


    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.addVertice(1);
        g.addVertice(2);
        g.addVertice(3);
        g.addVertice(4);
        g.addVertice(5);
        
        g.enlazar(1, 2);
        g.enlazar(1, 3);
        g.enlazar(2, 3);
        g.enlazar(2, 4);
        g.enlazar(3, 4);
        g.enlazar(3, 5);
        
        g.BFS();
        System.out.println("=======DFS==========");
        g.DFS();
        System.out.println("GRAPHVIZ");
        g.dibujar();
    }
    
}
