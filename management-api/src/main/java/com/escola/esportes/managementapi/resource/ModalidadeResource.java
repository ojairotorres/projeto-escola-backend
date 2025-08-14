package com.escola.esportes.managementapi.resource;

import com.escola.esportes.managementapi.entity.Modalidade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.Valid;

import java.util.List;

@ApplicationScoped
@Path("/modalidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModalidadeResource {

    @GET
    public List<Modalidade> listAll() {
        return Modalidade.listAll();
    }

    @POST
    @Transactional
    public Response create(@Valid Modalidade modalidade) {
        try {
            modalidade.persist();
            return Response.status(Response.Status.CREATED).entity(modalidade).build();
        } catch (PersistenceException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao persistir a modalidade: " + e.getMessage()).build();
        }
    }
}