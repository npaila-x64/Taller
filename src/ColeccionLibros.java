import java.util.Scanner;

public class ColeccionLibros {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[][] libros = new String[100][3];

        agregarLibro(libros,"El Hobbit","J.R.R. Tolkien","Ed. Planeta");
        agregarLibro(libros,"Cujo","Stephen King","Ed. Que susto");
        agregarLibro(libros,"Un mundo feliz","Aldous Huxley","Ed. No Me Acuerdo");

        menu(libros);
    }

    public static void menu(String[][] misLibros) {
        while (true) {
            mostrarMenu();
            switch (scanner.nextLine()) {
                case "1" -> mostrarMenuAgregarLibro(misLibros);
                case "2" -> mostrarBusquedaLibroPorTitulo(misLibros);
                case "3" -> mostrarTotalLibros(misLibros);
                case "4" -> mostrarEspaciosDisponibles(misLibros);
                case "5" -> mostrarTodaColeccion(misLibros);
            }
        }
    }

    public static void mostrarMenu() {
        System.out.print("""
                1) AGREGAR LIBRO
                2) BUSCAR LIBRO POR TITULO
                3) MOSTRAR ESPACIOS USADOS
                4) MOSTRAR ESPACIOS DISPONIBLES
                5) MOSTRAR TODA LA COLECCION
                Escoja alguna opción
                >\040""");
    }

    public static void mostrarMenuAgregarLibro(String[][] misLibros) {
        if (estaLaColeccionLlena(misLibros)) {
            System.out.println("La colección esta llena.");
            return;
        }
        System.out.print("Ingrese el titulo \n> ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor \n> ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la editorial \n> ");
        String editorial = scanner.nextLine();
        agregarLibro(misLibros, titulo, autor, editorial);
    }

    public static void agregarLibro(String[][] misLibros, String titulo, String autor, String editorial) {
        int indice = totalLibros(misLibros);
        misLibros[indice][0] = autor;
        misLibros[indice][1] = titulo;
        misLibros[indice][2] = editorial;
    }

    public static boolean estaLaColeccionLlena(String[][] misLibros) {
        return misLibros[misLibros.length - 1][0] != null;
    }

    public static int totalLibros(String[][] misLibros) {
        if (estaLaColeccionLlena(misLibros)) {
            return misLibros.length;
        }
        int totalLibros = -1;
        for (int indice = 0; indice < misLibros.length; indice++) {
            if (misLibros[indice][0] == null) {
                totalLibros = indice;
                break;
            }
        }
        return totalLibros;
    }

    public static int espaciosDisponibles(String[][] misLibros) {
        int espaciosDisponibles = misLibros.length - totalLibros(misLibros);
        return espaciosDisponibles;
    }

    public static void mostrarTotalLibros(String[][] misLibros) {
        System.out.print("Espacios usados: ");
        System.out.println(totalLibros(misLibros));
    }

    public static void mostrarEspaciosDisponibles(String[][] misLibros) {
        System.out.print("Espacios disponibles: ");
        System.out.println(espaciosDisponibles(misLibros));
    }

    public static void mostrarBusquedaLibroPorTitulo(String[][] misLibros) {
        System.out.print("Ingrese el titulo \n> ");
        for (int indice = 0; indice < totalLibros(misLibros); indice++) {
            if (misLibros[indice][1].equals(scanner.nextLine())) {
                System.out.println("El libro si se encuentra disponible:");
                System.out.println("Titulo: " + misLibros[indice][1]);
                System.out.println("Autor: " + misLibros[indice][0]);
                System.out.println("Editorial: " + misLibros[indice][2]);
                break;
            }
        }
    }

    public static void mostrarTodaColeccion(String[][] misLibros) {
        for (int indice = 0; indice < totalLibros(misLibros); indice++) {
            System.out.println(
                    String.join(", ",
                            misLibros[indice][1], misLibros[indice][0], misLibros[indice][2]));
        }
    }
}
