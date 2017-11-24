/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Usuario;

/**
 * Jersey REST client generated for REST resource:UsuarioRest [User]<br>
 * USAGE:
 * <pre>
 *        UsuarioCliente client = new UsuarioCliente();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author bryan
 */
@Named
@ViewScoped
public class UsuarioCliente implements Serializable{

    private Client cliente;
    private static final String BASE_URI = "http://localhost:8080/Guia08-1.0-SNAPSHOT/webresources/";
    List<Usuario> listaUsaurio;
    private String nombreBuscado;

    public UsuarioCliente() {
        cliente = ClientBuilder.newClient();
    }

    public void filtro(){
        
        List<Usuario> salida = null,filtro = new ArrayList<>();
        if(!nombreBuscado.isEmpty()){
        try {
            salida = cliente
                    .target(BASE_URI)
                    .path("User")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Usuario>>(){});
            
            for (Usuario usuario : salida) {
                if(usuario.getNombres().toLowerCase().matches(".*"+nombreBuscado.toLowerCase()+".*")){
                    System.out.println(usuario.getNombres());
                    filtro.add(usuario);
                }
            }
        } catch (Exception e) {
            System.out.println("ex: "+e);
        }finally{
           if(filtro.isEmpty()){
               filtro = Collections.EMPTY_LIST;
           }
        }
        }
        listaUsaurio = filtro;
    }
    
    public void mensaje(){
        System.out.println("ENTRO AQUI ALV PRRO");
    }
    
    public List<Usuario> getListaUsaurio() {
        return listaUsaurio;
    }

    public void setListaUsaurio(List<Usuario> listaUsaurio) {
        this.listaUsaurio = listaUsaurio;
    }

    public String getNombreBuscado() {
        return nombreBuscado;
    }

    public void setNombreBuscado(String nombreBuscado) {
        this.nombreBuscado = nombreBuscado;
    }
    
    
    
    
    
    public void close() {
        cliente.close();
    }
    
}
