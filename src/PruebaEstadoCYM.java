

/**
 *Prueba con cada uno de los estados vistos en clase
 * 
 * @author Jose Condori
 * @version 2 jun. 2021 12:26:26
 */
public class PruebaEstadoCYM {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {3, 3, 1};

        EstadoCYM bote01 = new EstadoCYM(a);
        NodoDeBusqueda raiz = new NodoDeBusqueda(bote01);
        
        BusquedaBFS.buscar(raiz);
    }
}
