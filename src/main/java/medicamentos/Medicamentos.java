package medicamentos;

/**
 *
 * @author adcan
 */
public class Medicamentos {

    private String tipo;
    private String nombre;
    private int stock;
    private String descripcion;

    public Medicamentos(String nombre, int stock, String tipo, String descripcion) {
        this.nombre = nombre;
        this.stock = stock;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock para reducir.");
        }
    }

    public boolean stockBajo(int limite) {
        return stock < limite;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
