
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Principal principal = new Principal();
    }

    public Principal() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scan.nextLine().trim());
            if (opcion == 1) {
                prestarPelicula();
            } else if (opcion == 2) {
                devolverPelicula();
            } else if (opcion == 3) {
                mostrarPeliculas();
            } else if (opcion == 4) {
                agregarPelicula();
            } else if (opcion == 5) {
                ordenarPeliculas();
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
    int[] idPelicula = new int[limite];
    String[] nombrePelicula = new String[limite];
    int[] anioPelicula = new int[limite];
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

    public void mostrarMenu() {
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
        if (controlCLiente == 0) {
            System.out.println("Ingresa el Id de el cliente");
            idC = Integer.parseInt(scan.nextLine().trim());
            idCliente[controlCLiente] = idC;
            pedirDatosCliente();
        } else if (controlCLiente == limite) {
            System.out.println("Ya no puede ingresar mas clientes");
        } else {
            boolean esta = false;
            System.out.println("Ingresa el Id de el cliente");
            idC = Integer.parseInt(scan.nextLine().trim());
            for (int i = 0; i < controlCLiente; i++) {
                if (idC == idCliente[i]) {
                    esta = true;
                    break;
                }
            }
            if (esta) {
                System.out.println("\nYa existe un cliente con ese Id\n");
            } else {
                idCliente[controlCLiente] = idC;
                pedirDatosCliente();
            }
        }
    }

    public void pedirDatosCliente() {
        String nombreC;
        int telefonoC;
        System.out.println("Ingresa el nombre del Cliente");
        nombreC = scan.nextLine();
        nombreCliente[controlCLiente] = nombreC;
        System.out.println("Ingresa el numero de telefono");
        telefonoC = Integer.parseInt(scan.nextLine().replaceAll(" ", ""));
        telefonoCliente[controlCLiente] = telefonoC;
        peliculaPrestada[controlCLiente] = false;
        System.out.println("\nCliente Agregado\n");
        controlCLiente++;
    }

    public void mostrarClientes() {
        System.out.println("\nSe han ingresado los siguientes Clientes");
        for (int i = 0; i < controlCLiente; i++) {
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
            idP = Integer.parseInt(scan.nextLine().trim());
            idPelicula[controlPelicula] = idP;
            pedirDatosPelicula();
        } else if (controlPelicula == limite) {
            System.out.println("No se puede agregar mas pelicular");
        } else {
            System.out.println("Ingresa el Id de la pelicula");
            idP = Integer.parseInt(scan.nextLine().trim());
            boolean esta = false;
            for (int i = 0; i < controlPelicula; i++) {
                if (idP == idPelicula[i]) {
                    esta = true;
                    break;
                }
            }
            if (esta) {
                System.out.println("\nYa existe una pelicula con ese Id\n");
            } else {
                idPelicula[controlPelicula] = idP;
                pedirDatosPelicula();
            }
        }
    }

    public void pedirDatosPelicula() {
        String nombreP;
        int anioP;
        String categoriaP;

        System.out.println("Ingresa el nombre de la pelicula");
        nombreP = scan.nextLine();
        nombrePelicula[controlPelicula] = nombreP;
        System.out.println("Ingresa el año en el que fue estrenada");
        anioP = Integer.parseInt(scan.nextLine().trim());
        anioPelicula[controlPelicula] = anioP;
        System.out.println("Ingresa la categoria de la pelicula");
        categoriaP = scan.nextLine();
        categoriaPelicula[controlPelicula] = categoriaP;
        disponible[controlPelicula] = true;
        System.out.println("\nPelicula Agregada\n");
        controlPelicula++;
    }

    public void mostrarPeliculas() {
        System.out.println("\nSe han registrado las siguientes peliculas");
        for (int i = 0; i < controlPelicula; i++) {
            System.out.print(idPelicula[i] + "     ");
            System.out.print(nombrePelicula[i] + "     ");
            System.out.print(anioPelicula[i] + "     ");
            System.out.print(categoriaPelicula[i] + "     ");
            if (disponible[i]) {
                System.out.print("Disponible\n");
            } else {
                System.out.print("No disponible\n");
            }
        }
    }

    public int buscarIdClienteP() {
        int posicion = 30;
        System.out.println("Ingrese el id del Cliente que va a prestar o que va a devolver");
        int id = Integer.parseInt(scan.nextLine().trim());
        boolean esta = true;
        int i;
        for ( i = 0; i < controlCLiente; i++) {
            if (id == idCliente[i]) {
                esta = false;
                break;
            }
        }
        if (esta == false) {
            return i;
        } else {
            System.out.println("No se encontro el Cliente");
        }
        return posicion;
    }

    public int buscarIdPeliculaP() {
        int posicion = 30;
        System.out.println("Ingrese el id de la Pelicula a prestar o a devolver");
        int id = Integer.parseInt(scan.nextLine().trim());
        boolean esta = true;
        int i;
        for (i = 0; i < controlPelicula; i++) {
            if (id == idPelicula[i]) {
                esta = false;
                break;
            }
        }
        if (esta == false) {
            return i;
        } else {
            System.out.println("No se encontro la Pelicula");
        }
        return posicion;
    }

    public boolean verPrestamo(int posicion) {
        if (!peliculaPrestada[posicion]) {
            return true;
        } else {
            System.out.println("Ya tiene una pelicula Prestada");
        }
        return false;
    }

    public boolean verDisponibilidad(int posicion) {
        if (disponible[posicion]) {
            return true;
        } else {
            System.out.println("La pelicula fue prestada");
        }
        return false;
    }

    public void mostrarPeliculasDisponible() {
        System.out.println("\nLas peliculas disponibles son:\n");
        for (int i = 0; i < controlPelicula; i++) {
            if (disponible[i]) {
                System.out.println(idPelicula[i] + "     " + nombrePelicula[i] + "     " + anioPelicula[i] + "     "
                        + categoriaPelicula[i]);
            }
        }
    }

    public void prestarPelicula() {
        System.out.println("\nSi quiere prestar una Pelicula, tome en cuenta lo siguiente:");
        System.out.println("1. Que usted no tenga otra pelicula Prestada en este momento.");
        System.out.println("2. Que la pelicula este disponible, es decir que no haya sido prestada");
        mostrarPeliculasDisponible();
        posicionP = buscarIdPeliculaP();
        posicionC = buscarIdClienteP();
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

    public void mostrarPeliculasPrestasda() {
        System.out.println("\nLas peliculas prestadas son\n");
        System.out.println("IdCliente----------IdPelicula----------DiasPrestados");
        for (int i = 0; i < controlprestamo; i++) {
            System.out.println(idPelicualasP[i] + "----------" + idPelicualasP[i] + "----------" + diasPrestados[i]);

        }
    }

    public void devolverPelicula() {
        mostrarPeliculasPrestasda();
        posicionP = buscarIdPeliculaP();
        posicionC = buscarIdClienteP();
        if (posicionC != 30 & posicionP != 30) {
            if (peliculaPrestada[posicionC] & !disponible[posicionP]) {
                System.out.println("Listo Pelicula devuelta, cliente libre para realizar otro prestamo");
                for (int i = 0; i < controlprestamo; i++) {
                    diasPrestados[i] = diasPrestados[i + 1];
                    idClientesP[i] = idClientesP[i + 1];
                    idPelicualasP[i] = idPelicualasP[i + 1];
                }
                peliculaPrestada[posicionC] = false;
                disponible[posicionP] = true;
                controlprestamo--;
            }
        }
    }

    public void ordenarPeliculas() {
        for (int i = 1; i < controlPelicula; i++) {
            for (int j = 0; j < controlPelicula - i; j++) {
                String nombre = nombrePelicula[j];
                String nombreSiguiente = nombrePelicula[j + 1];
                if (nombre.compareToIgnoreCase(nombreSiguiente) > 0) {
                    nombrePelicula[j] = nombreSiguiente;
                    nombrePelicula[j + 1] = nombre;
                    String aux = categoriaPelicula[j];
                    categoriaPelicula[j] = categoriaPelicula[j + 1];
                    categoriaPelicula[j + 1] = aux;
                    int aux1 = idPelicula[j];
                    idPelicula[j] = idPelicula[j + 1];
                    idPelicula[j + 1] = aux1;
                    aux1 = anioPelicula[j];
                    anioPelicula[j] = anioPelicula[j + 1];
                    anioPelicula[j + 1] = aux1;
                    boolean aux2 = disponible[j];
                    disponible[j] = disponible[j + 1];
                    disponible[j + 1] = aux2;

                }
            }
        }

    }

}