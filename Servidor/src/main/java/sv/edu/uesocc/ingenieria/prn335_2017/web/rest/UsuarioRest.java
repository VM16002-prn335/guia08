/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.rest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.UsuarioFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Usuario;

/**
 *
 * @author bryan
 */
@Path("User")
public class UsuarioRest implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll() {
        try {
            if (usuarioFacade != null) {
                return usuarioFacade.findAll();
            }
        } catch (Exception e) {
            System.out.println("ex: " + e);
        }

        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("{inicio}/{tamanio}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findRange(
            @PathParam("inicio") @DefaultValue("0") int inicio,
            @PathParam("tamanio") @DefaultValue("10") int tamanio) {
        try {
            if (usuarioFacade != null) {
                return usuarioFacade.findRange(inicio, tamanio);
            }
        } catch (Exception e) {
            System.out.println("ex: " + e);
        }
        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(
            @PathParam("id") int id) {
        try {
            if (usuarioFacade != null) {
                return usuarioFacade.find(id);
            }
        } catch (Exception e) {
            System.out.println("ex: " + e);
        }
        return new Usuario();
    }

//    @GET
//    @Path("like/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List findLike(
//            @PathParam("name") String nombre) {
//        try {
//            if (usuarioFacade != null) {
//                return usuarioFacade.filtradoLike(nombre);
//                 
//            }
//        } catch (Exception e) {
//            System.out.println("ex: " + e);
//        }
//        return Collections.EMPTY_LIST;
//    }
}

