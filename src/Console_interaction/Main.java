package Console_interaction;
import Area_de_compras.Boleteria;
import Registro.RegistradoraClientes;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String MOVIE_THEATER_NAME = "Cine Center";

        Boleteria boleteria = new Boleteria(MOVIE_THEATER_NAME);
        Utils.header("Welcome to: " + boleteria.name + " movie theater");

        // Menu
        Utils.showGeneralMenu();

        switch (Utils.getOption()){
            case 1:
                Utils.getMovie(boleteria);
                break;
            case 2:
                Utils.subheader("Registration Menu");
                RegistradoraClientes.registerCustomer(Utils.getCustomerData());
                break;
            default:
                System.out.println("do");
        }

    }
}