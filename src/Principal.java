import java.util.*;

public class Principal{
    public static void main(String[] args) {
        
    }

    public Principal(){
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scan.nextLine());
            if (opcion == 1) {
                prestarPelicula();
            } else if (opcion == 2) {
                
            } else if (opcion == 3) {
                mostrarPeliculas();
            } else if (opcion == 4) {
                agregarPelicula();
            } else if (opcion == 5) {
                
            } else if (opcion == 6) {
                agregarCliente();
            } else if (opcion == 7) {
                mostrarClientes();
            } else if (opcion == 8) {
                
            } else {
                System.out.println("----------Hasta Pronto----------");
            }
            
        } while (opcion < 9 & opcion >= 1);
    }
    Scanner scan = new Scanner(System.in);
    int limite = 30;
    int posicionC;
    int posicionP;
    int controlPelicula = 0;
    int controlCLientes = 0;
    int[] idPelicula = new int[limite];
    String[] nombrePelicula = new String[limite];
    int[] añoPelicula = new int[limite];
    String[] categoriaPelicula = new String[limite];
    boolean[] disponible = new boolean[limite];
    int controlCLiente = 0;
    String[] nombreCliente = new String[limite];
    int[] idCliente = new int[limite];
    int[] telefonoCliente = new int[limite];
    boolean[] peliculaPrestada = new boolean[limite];
    int controlprestamo = 0;
    int[] diasPrestados = new int[limite];
    int[] idClientesP = new int[limite];
    int[] idPelicualasP = new int[limite];
    

    public void mostrarMenu(){
        System.out.println("\n¿Que deseas hacer");
        System.out.println("Ingresa el numero que acompaña a la accion que deseas realizar");
        System.out.println("1. Prestar Peliculas");
        System.out.println("2. Devolver peliculas");
        System.out.println("3. Mostrar Peliculas");
        System.out.println("4. Ingresar Peliculas");
        System.out.println("5. Ordenar Peliculas");
        System.out.println("6. Ingresar Clientes");
        System.out.println("7. Mostrar Clientes");
        System.out.println("8. Reportes");
        System.out.println("9. Salir\n");
    }

    public void agregarCliente() {
        int idC;
        System.out.println("");
        if (controlCLientes == 0) {
            System.out.println("Ingresa el Id de el cliente");
            idC = Integer.parseInt(scan.nextLine());
            idCliente[controlCLientes] = idC;
            pedirDatosCliente();
        } else if (controlCLientes == limite) {
            System.out.println("Ya no puede ingresar mas clientes");
        } else {
            for (int i = 0; i < controlCLientes; i++) {
                System.out.println("Ingresa el Id de el cliente");
                idC = Integer.parseInt(scan.nextLine());
                if (idC == idCliente[i]) {
                    System.out.println("\nYa existe un cliente con ese Id\n");
                } else {
                    idCliente[controlCLientes] = idC;
                    pedirDatosCliente();
                    break;
                }
            }
        }
    }

    public void pedirDatosCliente() {
        String nombreC;
        int telefonoC;
        System.out.println("Ingresa el nombre del Cliente");
        nombreC = scan.nextLine();
        nombreCliente[controlCLientes] = nombreC;
        System.out.println("Ingresa el numero de telefono");
        telefonoC = Integer.parseInt(scan.nextLine());
        telefonoCliente[controlCLientes] = telefonoC;
        peliculaPrestada[controlCLientes] = false;
        System.out.println("\nCliente Agregado\n");
        controlCLientes++;
    }

    public void mostrarClientes(){
        System.out.println("\nSe han ingresado los siguientes Clientes");
        for (int i = 0; i < controlCLientes; i++) {
            System.out.print(idCliente[i] + "     ");
            System.out.print(nombreCliente[i] + "     ");
            System.out.print(telefonoCliente[i] + "     ");
            if (!peliculaPrestada[i]) {
                System.out.print("No ha prestado peliculas\n");
            } else {
                System.out.print("Tiene prestada una pelicula\n");
            }
        }
    }


    public void agregarPelicula() {
        int idP;
        System.out.println("");
        if (controlPelicula == 0) {
            System.out.println("Ingresa el Id de la pelicula");
            idP = Integer.parseInt(scan.nextLine());
            idPelicula[controlPelicula] = idP;
            pedirDatosPelicula();
        } else if (controlPelicula == limite) {
            System.out.println("No se puede agregar mas pelicular");
        } else {
            for (int i = 0; i < controlPelicula; i++) {
                System.out.println("Ingresa el Id de la pelicula");
                idP = Integer.parseInt(scan.nextLine());
                if (idP == idPelicula[i]) {
                    System.out.println("\nYa existe una pelicula con ese Id\n");
                } else {
                    idPelicula[controlPelicula] = idP;
                    pedirDatosPelicula();
                    break;
                }
            }
        }
    }

    public void pedirDatosPelicula() {
        String nombreP;
        int añoP;
        String categoriaP;

        System.out.println("Ingresa el nombre de la pelicula");
        nombreP = scan.nextLine();
        nombrePelicula[controlPelicula] = nombreP;
        System.out.println("Ingresa el año en el que fue estrenada");
        añoP = Integer.parseInt(scan.nextLine());
        añoPelicula[controlPelicula] = añoP;
        System.out.println("Ingresa la categoria de la pelicula");
        categoriaP = scan.nextLine();
        categoriaPelicula[controlPelicula] = categoriaP;
        disponible[controlPelicula] = true;
        System.out.println("\nPelicula Agregada\n");
        controlPelicula++;
    }
    public void mostrarPeliculas(){
        System.out.println("\nSe han registrado las siguientes peliculas");
            for (int i = 0; i < controlPelicula; i++) {
                System.out.print(idPelicula[i] + "     ");
                System.out.print(nombrePelicula[i] + "     ");
                System.out.print(añoPelicula[i] + "     ");
                System.out.print(categoriaPelicula[i] + "     ");
                if (disponible[i]) {
                    System.out.print("Disponible\n");
                } else {
                    System.out.print("No disponible\n");
                }
            }
    }
    public int buscarIdClienteP(){
        int posicion = 30;
        System.out.println("Ingrese el id del Cliente");
        int id = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < controlCLiente; i++) {
            if (id == idCliente[i]) {
                return i;
            } else {
                System.out.println("No se encontro el Cliente");
            }
        }
        return posicion;
    }
    public int buscarIdPeliculaP(){
        int posicion = 30;
        System.out.println("Ingrese el id de la Pelicula");
        int id = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < controlPelicula; i++) {
            if (id == idClientesP[i]) {
                return i;
            } else {
                System.out.println("No se encontro la Pelicula");
            }
        }
        return posicion;
    }

    public boolean verPrestamo(int posicion){
        if (!peliculaPrestada[posicion]) {
            return true;
        } else {
            System.out.println("Ya tiene una pelicula Prestada");
        }
        return false;
    }
    public boolean verDisponibilidad(int posicion){
        if (disponible[posicion]) {
            return true;
        } else {
            System.out.println("La pelicula fue prestada");
        }
        return false;
    }


    public void prestarPelicula(){
        System.out.println("\nSi quiere prestar una Pelicula, tome en cuenta lo siguiente:");
        System.out.println("1. Que usted no tenga otra pelicula Prestada en este momento.");
        System.out.println("2. Que la pelicula este disponible, es decir que no haya sido prestada");
        posicionC = buscarIdClienteP();
        posicionP = buscarIdPeliculaP();
        if (posicionC != 30 & posicionP != 30) {
            if (verPrestamo(posicionC) & verDisponibilidad(posicionP)) {
                System.out.println("Cuantos dias prestara la pelicula");
                diasPrestados[controlprestamo] = Integer.parseInt(scan.nextLine());
                idClientesP[controlprestamo] = idCliente[posicionC];
                idPelicualasP[controlprestamo] = idPelicula[posicionP];
                peliculaPrestada[posicionC] = true;
                disponible[posicionP] = false;
                controlprestamo++;
            }
        }
        
    }

    public void devolverPelicula(){
        
    }



}