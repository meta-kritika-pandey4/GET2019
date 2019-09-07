package com.metacube.get2019.controller;

import java.sql.SQLException;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.metacube.get2019.factory.InventoryFacade;

@Path("/inventory")
public class InventoryController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllFruits() throws SQLException
	{
		String response=InventoryFacade.getFruits();
		return response;
	}
	
	@Path("/{fruitName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getFruitByName(@PathParam("fruitName") String fruitName) throws SQLException
	{
		System.out.println(fruitName);
		String response=InventoryFacade.getFruitByName(fruitName);
		return response;
	}

}
