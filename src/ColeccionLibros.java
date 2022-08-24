public class ColeccionLibros {

    public static void main(String[] args) {

        String[][] libros = new String[100][3];

        agregarLibro(libros,"El Hobbit","J.R.R. Tolkien","Ed. Planeta");
        agregarLibro(libros,"Cujo","Stephen King","Ed. Que susto");
        agregarLibro(libros,"Un mundo feliz","Aldous Huxley","Ed. No Me Acuerdo");

        menu();
    }

    public static void menu() {

    }

    public static String[][] agregarLibro(String[][] misLibros, String titulo, String autor, String editorial) {
        return new String[][]{};
    }

    public static int totalLibros(String[][] misLibros) {
        return 0;
    }

    public static int espaciosDisponibles(String[][] misLibros) {
        return 0;
    }

    public static void mostrarTotalLibros(String[][] misLibros) {

    }

    public static void mostrarEspaciosDisponibles(String[][] misLibros) {

    }

    public static void mostrarBusquedaLibroAutor(String[][] misLibros, String autor) {

    }

    public static void mostrarTodaColeccion(String[][] misLibros) {

    }
}

