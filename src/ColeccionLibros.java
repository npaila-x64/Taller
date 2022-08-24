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
            System.out.println("1) AGREGAR LIBRO");
            System.out.println("2) BUSCAR LIBRO POR TITULO");
            System.out.println("3) MOSTRAR ESPACIOS USADOS");
            System.out.println("4) MOSTRAR ESPACIOS DISPONIBLES");
            System.out.println("5) MOSTRAR TODA LA COLECCION");
            System.out.print("Escoja alguna opción \n> ");
            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("Ingrese el titulo \n> ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor \n> ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese la editorial \n> ");
                    String editorial = scanner.nextLine();
                    agregarLibro(misLibros, titulo, autor, editorial);
                    break;
                case "2":
                    System.out.print("Ingrese el titulo \n> ");
                    mostrarBusquedaLibroPorTitulo(misLibros, scanner.nextLine());
                    break;
                case "3":
                    mostrarTotalLibros(misLibros);
                    break;
                case "4":
                    mostrarEspaciosDisponibles(misLibros);
                    break;
                case "5":
                    mostrarTodaColeccion(misLibros);
                    break;
            }
            System.out.println();
        }
    }

    public static void probarMetodos(String[][] misLibros) {
        agregarLibro(misLibros, "Utopía", "Tomás Moro", "Ed. Pingüino");
        System.out.println("Toda colección");
        mostrarTodaColeccion(misLibros);
        System.out.println("Total libros");
        mostrarTotalLibros(misLibros);
        System.out.println("Espacios disponibles");
        mostrarEspaciosDisponibles(misLibros);
        mostrarBusquedaLibroPorTitulo(misLibros, "Utopía");
    }

    public static void agregarLibro(String[][] misLibros, String titulo, String autor, String editorial) {

        if (estaLaColeccionLlena(misLibros)) {
            System.out.println("La colección esta llena.");
            return;
        }

        for (int i = 0; i < misLibros.length; i++) {
            if (misLibros[i][0] == null) {
                misLibros[i][0] = autor;
                misLibros[i][1] = titulo;
                misLibros[i][2] = editorial;
                break;
            }
        }
    }

    public static boolean estaLaColeccionLlena(String[][] misLibros) {
        return misLibros[99][0] != null;
    }

    public static int totalLibros(String[][] misLibros) {

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

        int espaciosDisponibles = -1;

        for (int i = 0; i < misLibros.length; i++) {
            if (misLibros[i][0] == null) {
                espaciosDisponibles = 100 - i;
                break;
            }
        }

        return espaciosDisponibles;
    }

    public static void mostrarTotalLibros(String[][] misLibros) {
        System.out.println(totalLibros(misLibros));
    }

    public static void mostrarEspaciosDisponibles(String[][] misLibros) {
        System.out.println(espaciosDisponibles(misLibros));
    }

    public static void mostrarBusquedaLibroPorTitulo(String[][] misLibros, String titulo) {
        for (int i = 0; i < misLibros.length; i++) {
            if (misLibros[i][0] == null) {
                System.out.println("No se encuentra disponible el libro.");
                break;
            }
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
        for (int i = 0; i < misLibros.length; i++) {
            if (misLibros[i][0] == null) {
                break;
            }
            System.out.println(misLibros[i][0] + ", " + misLibros[i][1] + ", " + misLibros[i][2]);
        }
    }
}

