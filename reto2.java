
/*
* RETO 2:
* Deseamos notificar a los estudiantes sobre una incidencia por la cual no se celebrarán la clase programadas para el siguiente día en el instituto. Esta incidencia afecta a dos asignaturas y sólo afecta a los alumnos que asisten a la sede ubicada en Málaga. La información de la que disponemos son tres listas de los estudiantes que están matriculados en cada asignatura:
*  - Lista A: Nombres de estudiantes matriculados en Matemáticas. (De todas las sedes)
*  - Lista B: Nombres de estudiantes matriculados en Francés. (De todas las sedes)
*  - Lista C: Nombres de estudiantes matriculados en Matemáticas y Francés. (De todas las sedes)
*  
* Escriba una función en Java para que sean notificados los estudiantes de cada asignatura de manera que cada uno de los estudiantes sólo reciba un email y los emails a enviar a cada una de las tres listas son diferentes.
* De cada estudiante sabemos su nombre y la sede donde está matriculado.
* 
* 
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Fabian Camayo
 */
public class reto2 {

    public static void main(String args[]) {
        String[] nombres = { "Fabian", "Susana", "Luisa", "Andres", "David", "Maria", "Clark", "Natalia",
                "Isabella", "Aurelio", "Jose", "Guadalupe", "Beatriz", "Armando", "Gustavo", "Mauricio", "Vanessa",
                "Linda", "Felipe", "Luis", "Karen", "Juan", "Antonio", "Yessica", "Sergio", "Tatiana", "Paula",
                "Simon" };
        String[] sedes = { "Malaga", "Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza", "Murcia", "Palma",
                "Bilbao", "Alicante", "Cordoba", "Vigo", "Valladolid", "Vitoria", "Elche", "Granada", "Tarrasa",
                "Badalona", "Oviedo", "Cartagena" };
        Random r = new Random();
        String nombreRandom;

        List<Estudiante> lista_a = new ArrayList<Estudiante>();
        List<String> nombresListA = new ArrayList<String>();
        nombreRandom = nombres[r.nextInt(nombres.length)];
        nombresListA.add(nombreRandom);
        List<Estudiante> lista_b = new ArrayList<Estudiante>();
        List<String> nombresListB = new ArrayList<String>();
        nombreRandom = nombres[r.nextInt(nombres.length)];
        nombresListB.add(nombreRandom);
        List<Estudiante> lista_c = new ArrayList<Estudiante>();

        for (int i = 0; i < nombres.length; i++) {
            nombreRandom = nombres[r.nextInt(nombres.length)];
            if (!nombresListA.toString().contains(nombreRandom)) {
                nombresListA.add(nombreRandom);
                Estudiante estudiante_a = new Estudiante();
                estudiante_a.setNombre(nombreRandom);
                estudiante_a.setCorreo(estudiante_a.getNombre() + "@gmail.com");
                estudiante_a.setSede(sedes[r.nextInt(sedes.length)]);
                estudiante_a.setAsignatura("Matematicas");
                lista_a.add(estudiante_a);
            }
        }

        for (int i = 0; i < nombres.length; i++) {
            nombreRandom = nombres[r.nextInt(nombres.length)];
            if (!nombresListB.toString().contains(nombreRandom)) {
                nombresListB.add(nombreRandom);
                Estudiante estudiante_b = new Estudiante();
                estudiante_b.setNombre(nombreRandom);
                estudiante_b.setCorreo(estudiante_b.getNombre() + "@gmail.com");
                estudiante_b.setSede(sedes[r.nextInt(sedes.length)]);
                estudiante_b.setAsignatura("Frances");
                lista_b.add(estudiante_b);
            }
        }

        for (Estudiante _estudiante_a : lista_a) {
            for (Estudiante _estudiante_b : lista_b) {
                if (_estudiante_a.getNombre().equals(_estudiante_b.getNombre())) {
                    _estudiante_b.setSede(_estudiante_a.getSede());
                    Estudiante estudiante_ab = new Estudiante();
                    estudiante_ab.setNombre(_estudiante_a.getNombre());
                    estudiante_ab.setCorreo(_estudiante_a.getCorreo());
                    estudiante_ab.setSede(_estudiante_a.getSede());
                    estudiante_ab.setAsignatura(_estudiante_a.getAsignatura() + " - " + _estudiante_b.getAsignatura());
                    lista_c.add(estudiante_ab);
                }
            }
        }

        System.out.println("---------------------LISTA A MATEMATICAS---------------------");
        for (Estudiante estudiante : lista_a) {
            System.out.println(estudiante.getNombre() + " | " + estudiante.getCorreo() + " | " + estudiante.getSede()
                    + " | " + estudiante.getAsignatura());
        }
        System.out.println("---------------------LISTA B FRANCES---------------------");
        for (Estudiante estudiante : lista_b) {
            System.out.println(estudiante.getNombre() + " | " + estudiante.getCorreo() + " | " + estudiante.getSede()
                    + " | " + estudiante.getAsignatura());
        }
        System.out.println("---------------------LISTA C FRANCES Y MATEMATICAS---------------------");
        for (Estudiante estudiante : lista_c) {
            System.out.println(estudiante.getNombre() + " | " + estudiante.getCorreo() + " | " + estudiante.getSede()
                    + " | " + estudiante.getAsignatura());
        }
        notificarIncidencia(lista_a, lista_b, lista_c);
    }

    static void notificarIncidencia(List<Estudiante> lista_a, List<Estudiante> lista_b, List<Estudiante> lista_c) {
        System.out.println("---------------------ENVIAR CORREOS---------------------");
        List<String> logCorreosEnviados = new ArrayList<String>();
        for (Estudiante estudiante : lista_c) {
            enviarEmail(estudiante.getNombre(), estudiante.getCorreo());
            logCorreosEnviados.add(estudiante.getCorreo());
        }

        
        for (Estudiante estudiante_a : lista_a) {
            if (!logCorreosEnviados.toString().contains(estudiante_a.getCorreo())) {
                enviarEmail(estudiante_a.getNombre(), estudiante_a.getCorreo());
                logCorreosEnviados.add(estudiante_a.getCorreo());
            }
        }

        for (Estudiante estudiante_b : lista_b) {
            if (!logCorreosEnviados.toString().contains(estudiante_b.getCorreo())) {
                enviarEmail(estudiante_b.getNombre(), estudiante_b.getCorreo());
                logCorreosEnviados.add(estudiante_b.getCorreo());
            }

        }

    }

    static void enviarEmail(String nombre, String correo) {
        System.out.println(nombre + " | " + correo);
    }

}
