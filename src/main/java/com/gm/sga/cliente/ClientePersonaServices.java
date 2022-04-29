
package com.gm.sga.cliente;

import col.com.gm.sga.servicio.PersonaServiceRemote;
import col.innovfashion.sga.domain.Persona;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ClientePersonaServices {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al ejb desde el cliente");
        
        try {
            Context jdn = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jdn.lookup("java:global/sga-jee/PersonaServiceImpl!col.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas =  personaService.listarPersonas();
            for (Persona persona : personas) {
                System.out.println("Usuario: "+persona);
            }
            System.out.println("\nFin del llamada al ejb desde el cliente");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
