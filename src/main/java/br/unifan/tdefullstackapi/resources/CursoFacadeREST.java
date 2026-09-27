package br.unifan.tdefullstackapi.resources;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
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

import br.unifan.tdefullstackapi.entity.Curso;
import br.unifan.tdefullstackapi.dao.CursoDAO;

@Stateless
@Path("curso")
public class CursoFacadeREST {

    @Inject
    private CursoDAO cursoDAO; // Injeta o DAO de cursos separado

    public CursoFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Curso entity) {
        cursoDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Curso entity) {
        // Supondo que sua entidade Curso use setIdCurso. Ajuste se o nome do método for diferente.
        entity.setIdCurso(id); 
        cursoDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        cursoDAO.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Curso find(@PathParam("id") Integer id) {
        return cursoDAO.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Curso> findAll() {
        return cursoDAO.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Curso> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return cursoDAO.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return cursoDAO.countREST();
    }
}