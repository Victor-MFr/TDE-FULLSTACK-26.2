package br.unifan.tdefullstackapi.resources;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import br.unifan.tdefullstackapi.entity.Avaliacao;
import br.unifan.tdefullstackapi.dao.AvaliacaoDAO;

@Stateless
@Path("avaliacao")
public class AvaliacaoFacadeREST {
    
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Avaliacao entity) {
        avaliacaoDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Avaliacao entity) {
        entity.setIdAvaliacao(id);
        avaliacaoDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        avaliacaoDAO.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Avaliacao find(@PathParam("id") Integer id) {
        return avaliacaoDAO.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Avaliacao> findAll() {
        return avaliacaoDAO.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Avaliacao> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return avaliacaoDAO.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return avaliacaoDAO.countREST();
    }
}