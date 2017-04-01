package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.singleton.EMFactorySingleton;

@Path("/aluno")
public class AlunoResource {

	private AlunoDAO dao;

	public AlunoResource() {
		dao = new AlunoDAOImpl(EMFactorySingleton.getInstance());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(String json) {
		Aluno aluno = new Gson().fromJson(json, Aluno.class);
		try {
			dao.insert(aluno);
			return Response.status(201).build();
		} catch (DBCommitException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("id") int id) {

		Aluno aluno = dao.findById(id);

		return new Gson().toJson(aluno);
	}
	
	@GET
	@Path("/search/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarPorNome(@PathParam("nome") String nome) {

		List<Aluno> aluno = dao.buscarPorNome(nome);

		return new Gson().toJson(aluno);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar() {
		List<Aluno> alunos = dao.list();
		return new Gson().toJson(alunos);
	}

	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") int id) {
		try {
			dao.delete(id);
			return Response.status(200).entity("Apagado!").build();
		} catch (DBCommitException | IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return Response.status(500).entity("Erro").build();

		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(String json) {
		Aluno aluno = new Gson().fromJson(json, Aluno.class);
		try {
			dao.update(aluno);
			return Response.status(200).build();

		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}

	}

}
