import java.util.Scanner;

public class ColeccionLibros {

    public static void main(String[] args) {

        String[][] libros = new String[100][3];

        agregarLibro(libros,"El Hobbit","J.R.R. Tolkien","Ed. Planeta");
        agregarLibro(libros,"Cujo","Stephen King","Ed. Que susto");
        agregarLibro(libros,"Un mundo feliz","Aldous Huxley","Ed. No Me Acuerdo");

        menu(libros);
    }

    public static void menu(String[][] misLibros) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1) AGREGAR LIBRO");
            System.out.println("2) BUSCAR LIBRO POR TITULO");
            System.out.println("3) MOSTRAR ESPACIOS USADOS");
            System.out.println("4) MOSTRAR ESPACIOS DISPONIBLES");
            System.out.println("5) MOSTRAR TODA LA COLECCION");
            System.out.print("Escoja alguna opción \n> ");
            switch (scanner.nextLine()) {
                case "1":
                    mostrarMenuAgregarLibro(misLibros);
                    break;
                case "2":
                    System.out.print("Ingrese el titulo \n> ");
                    mostrarBusquedaLibroPorTitulo(misLibros, scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Espacios usados: ");
                    mostrarTotalLibros(misLibros);
                    break;
                case "4":
                    System.out.print("Espacios disponibles: ");
                    mostrarEspaciosDisponibles(misLibros);
                    break;
                case "5":
                    mostrarTodaColeccion(misLibros);
                    break;
            }
        }
    }

    public static void mostrarMenuAgregarLibro(String[][] misLibros) {

        if (estaLaColeccionLlena(misLibros)) {
            System.out.println("La colección esta llena.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
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

        for (int i = 0; i < misLibros.length; i++) {
            if (misLibros[i][0] == null) {
                totalLibros = i;
                break;
            }
        }
        return totalLibros;
    }

    public static int espaciosDisponibles(String[][] misLibros) {

        if (estaLaColeccionLlena(misLibros)) {
            return 0;
        }

        int espaciosDisponibles = -1;

        int totalLibros = totalLibros(misLibros);
        espaciosDisponibles = misLibros.length - totalLibros;

        return espaciosDisponibles;
    }

    public static void mostrarTotalLibros(String[][] misLibros) {
        System.out.println(totalLibros(misLibros));
    }

    public static void mostrarEspaciosDisponibles(String[][] misLibros) {
        System.out.println(espaciosDisponibles(misLibros));
    }

    public static void mostrarBusquedaLibroPorTitulo(String[][] misLibros, String titulo) {
        for (int i = 0; i < totalLibros(misLibros); i++) {
            if (misLibros[i][1].equals(titulo)) {
                System.out.println("El libro si se encuentra disponible:");
                System.out.println("Titulo: " + misLibros[i][1]);
                System.out.println("Autor: " + misLibros[i][0]);
                System.out.println("Editorial: " + misLibros[i][2]);
                break;
            }
        }
    }

    public static void mostrarTodaColeccion(String[][] misLibros) {
        for (int i = 0; i < totalLibros(misLibros); i++) {
            System.out.println(misLibros[i][1] + ", " + misLibros[i][0] + ", " + misLibros[i][2]);
        }
    }
}

