
/*
* RETO 1:
* 
* Deseamos  escribir un informe realizando recortes de una revista publicada y uniendo estos recortes. Antes de hacer esto, le gustaría saber si es posible escribir su informe usando una determinada revista.
* Escriba una función en Java que tenga como entrada dos cadenas de caracteres; la primera de ellas será la nota que deseamos escribir y la segunda cadena de caracteres será el texto completo de la revista que poseemos. La función debe determinar si la nota puede ser escrita con la revista dada.
* 
* Por favor, explica cómo tu función determinará la respuesta en términos de longitud del informe (n) y de la revista (m)
* 
* Parámetros de prueba:
*
*   Nota: Esta es una nota especial, contiene a la revista, cuando yo estaba caminando en el parque vi un perro muy bonito.
*   Revista: Esta es la revista completa, cuando yo estaba caminando en el parque vi un perro muy bonito y una señora muy anciana que caminaba muy lentamente acompañada de su dulce nieta.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fabian Camayo
 */
public class reto1 {

    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String nota, revista;

        System.out.println("Ingrese el texto de la nota: ");
        nota = teclado.nextLine();
        System.out.println("Ingrese el texto de la revista: ");
        revista = teclado.nextLine();

        System.out.println(buscarNotaRevista(nota, revista));
    }

    static String buscarNotaRevista(String nota, String revista) {
        String respuestaNegativa = "La nota No puede ser escrita con la revista";
        String respuestaAfirmativa = "La nota puede ser escrita con la revista";

        if (revista.toLowerCase().contains(nota.toLowerCase())) {
            return respuestaAfirmativa;
        }

        String[] list_nota = nota.split(" ");
        List<Integer> list_index = new ArrayList<Integer>();
        for (int i = 0; i < list_nota.length; i++) {

            if (revista.toLowerCase().contains(list_nota[i].toLowerCase().replaceAll("\\p{Punct}", ""))) {
                list_index.add(i);
            }

        }

        Boolean bandera = true;
        List<List<Integer>> list_parrafos = new ArrayList<List<Integer>>();
        List<Integer> list_parrafos_temp = new ArrayList<Integer>();
        int proximo = 0;
        for (int i = 0; i <= list_index.size() - 1; i++) {

            if (i == list_index.size() - 1) {
                proximo = list_index.get(list_index.size() - 1) + 1;
                bandera = false;
            } else {
                proximo = list_index.get(i + 1);
            }

            if ((list_index.get(i)) == (proximo - 1)) {
                list_parrafos_temp.add(list_index.get(i));
            } else {
                bandera = false;
            }

            if (!bandera) {
                if (list_parrafos_temp.size() > 3) {
                    list_parrafos.add(list_parrafos_temp);
                }
                list_parrafos_temp.clear();
                bandera = true;
            }

        }

        if (list_parrafos.size() >= 1) {
            return respuestaAfirmativa;
        }

        return respuestaNegativa;
    }
}
