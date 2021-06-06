
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jose Condori
 * @version 2 jun. 2021 12:26:26
 */
public class PruebaEstadoCYM {

    public static void main(String[] args) {
        int[] a = {2, 1, 3};
        int[] b = {0, 0, 0};
        int[] c = {2, 1, 3};

        EstadoCYM bote01 = new EstadoCYM(a);
        EstadoCYM bote02 = new EstadoCYM(b);
        EstadoCYM bote03 = new EstadoCYM(c);

        System.out.println("Es meta bote01: " + bote01.esMeta());
        System.out.println("Es meta bote02: " + bote02.esMeta());

        System.out.println("Boteo1 es igual bote02: " + bote01.igual(bote02));
        System.out.println("Boteo1 es igual bote03: " + bote01.igual(bote03));

//        bote01.mostrarEstado();
//        bote02.mostrarEstado();
//        int[] copia = bote01.copiarBote(a);
//        for (int i : copia) {
//            System.out.print(i + " ");
//        }
//        for (int i : bote01.getBoteComplemento()) {
//            System.out.print(i + " ");
//        }
        ArrayList<int[]> botes = new ArrayList<>();

        botes.add(0, new int[]{3, 3, 1});
        botes.add(1, new int[]{3, 2, 0});
        botes.add(2, new int[]{3, 1, 0});
        botes.add(3, new int[]{2, 2, 0});
        botes.add(4, new int[]{3, 2, 1});
        botes.add(5, new int[]{3, 0, 0});
        botes.add(6, new int[]{3, 1, 1});
        botes.add(7, new int[]{1, 1, 0});
        botes.add(8, new int[]{2, 2, 1});
        botes.add(9, new int[]{0, 2, 0});
        botes.add(10, new int[]{0, 3, 1});
        botes.add(11, new int[]{0, 1, 0});
        botes.add(12, new int[]{1, 1, 1});
        botes.add(13, new int[]{0, 2, 1});

        ArrayList<EstadoCYM> estados = new ArrayList<>();

        Iterator<int[]> iterator = botes.iterator();
        int position = 0;
        while (iterator.hasNext()) {
            EstadoCYM estado = new EstadoCYM(iterator.next());
            estados.add(position, estado);
            position++;
        }
        
        ArrayList<ArrayList<Estado>> sucesores = new ArrayList<>();
        for (EstadoCYM estado : estados) {
            sucesores.add(estado.generarSucesores());
        }
        
        int numBote = 0;
        for (ArrayList<Estado> suc : sucesores) {
            System.out.print("=> ");
            estados.get(numBote).mostrarEstado();
            System.out.println("");
            for (Estado estado : suc) {
                estado.mostrarEstado();
            }
            numBote++;
            System.out.println("================");
        }

    }
}
