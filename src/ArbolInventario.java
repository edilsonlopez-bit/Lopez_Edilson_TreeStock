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
}
