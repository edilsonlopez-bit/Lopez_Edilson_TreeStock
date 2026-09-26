public class ArbolInventario {

    private Producto raiz;

    public ArbolInventario() {
        raiz = null;
    }

    // Inicia la insercion desde la raiz
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    // Busca la posicion correcta para el producto nuevo
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) {
            return new Producto(id, nombre);
        }

        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        } else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        }

        return actual;
    }

    // Inicia la busqueda desde la raiz
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    // Compara el id y avanza por el lado correspondiente
    private Producto buscarRecursivo(Producto actual, int id) {
        if (actual == null || actual.getId() == id) {
            return actual;
        }

        if (id < actual.getId()) {
            return buscarRecursivo(actual.getIzquierdo(), id);
        }

        return buscarRecursivo(actual.getDerecho(), id);
    }

    // Inicia el recorrido ordenado del inventario
    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("El inventario esta vacio");
            return;
        }

        recorridoInorden(raiz);
    }

    // Recorre izquierda raiz y derecha
    private void recorridoInorden(Producto actual) {
        if (actual != null) {
            recorridoInorden(actual.getIzquierdo());
            System.out.println("ID: " + actual.getId() + " | Nombre: " + actual.getNombre());
            recorridoInorden(actual.getDerecho());
        }
    }
}
