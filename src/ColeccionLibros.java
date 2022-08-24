public class ColeccionLibros {

    public static void main(String[] args) {

        String[][] libros = new String[100][3];

        agregarLibro(libros,"El Hobbit","J.R.R. Tolkien","Ed. Planeta");
        agregarLibro(libros,"Cujo","Stephen King","Ed. Que susto");
        agregarLibro(libros,"Un mundo feliz","Aldous Huxley","Ed. No Me Acuerdo");

        menu(libros);
    }

    public static void menu(String[][] misLibros) {

        System.out.println("Toda colección");
        mostrarTodaColeccion(misLibros);
        System.out.println("Total libros");
        mostrarTotalLibros(misLibros);
        System.out.println("Espacios disponibles");
        mostrarEspaciosDisponibles(misLibros);

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

    public static void mostrarBusquedaLibroAutor(String[][] misLibros, String autor) {

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

