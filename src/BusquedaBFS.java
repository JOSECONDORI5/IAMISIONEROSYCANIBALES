
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Jose Condori
 * @version 14 jun. 2021 09:01:02
 */
public class BusquedaBFS {

    public static void buscar(NodoDeBusqueda raiz) {
        Queue<NodoDeBusqueda> cola = new LinkedList<>();
        cola.add(raiz);
        realizarBusqueda(cola);
    }

    public static void realizarBusqueda(Queue<NodoDeBusqueda> cola) {
        int contadorBusqueda = 1;

        while (!cola.isEmpty()) {
            NodoDeBusqueda nodoTemp = cola.poll();
            if (nodoTemp.getEstadoActual().esMeta()) {
                Stack<NodoDeBusqueda> caminoSolucion = new Stack<>();
                caminoSolucion.push(nodoTemp);
                nodoTemp = nodoTemp.getPadre();

                while (nodoTemp.getPadre() != null) {
                    caminoSolucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getPadre();
                }
                caminoSolucion.push(nodoTemp);
                System.out.println("Solucion");

                while (!caminoSolucion.isEmpty()) {
                    nodoTemp = caminoSolucion.pop();
                    nodoTemp.getEstadoActual().mostrarEstado();
                    // System.out.println("\n");
                }
                System.out.println("Número de nodos examinados: " + contadorBusqueda);
                System.exit(0);
            } else {
                ArrayList<Estado> sucesoresTemp = nodoTemp.getEstadoActual().generarSucesores();

                for (int i = 0; i < sucesoresTemp.size(); i++) {
                    NodoDeBusqueda nuevoNodo = new NodoDeBusqueda(nodoTemp, sucesoresTemp.get(i));
                    if (!revisarRepetidos(nuevoNodo)) {
                        cola.add(nuevoNodo);
                    }
                }
            }
            contadorBusqueda++;
        }
    }

    public static boolean revisarRepetidos(NodoDeBusqueda nodo) {
        NodoDeBusqueda nodoTemp = nodo;

        while (nodoTemp.getPadre() != null) {
            if (nodoTemp.equals(nodoTemp.getPadre())) {
                return true;
            }
            nodoTemp = nodoTemp.getPadre();
        }
        return false;
    }
}
