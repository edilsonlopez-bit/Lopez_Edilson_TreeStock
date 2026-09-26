public class Producto {

    private int id;
    private String nombre;
    private Producto izquierdo;
    private Producto derecho;

    // Guarda los datos del producto dentro del nodo
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }
}
