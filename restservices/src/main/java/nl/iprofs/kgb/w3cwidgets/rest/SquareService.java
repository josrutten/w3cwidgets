package nl.iprofs.kgb.w3cwidgets.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/square/{number}")
public class SquareService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculateSquare(@PathParam("number") String number) {
		int value;
		try {
			value = Integer.valueOf(number);
		} catch (NumberFormatException nfe) {
			value = 0;
		}
		int result = value * value;

		SquareResult squareResult = new SquareResult(result);
		// add special header to make response work together with jquery
		return Response.ok(squareResult, MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*").build();
	}
}
