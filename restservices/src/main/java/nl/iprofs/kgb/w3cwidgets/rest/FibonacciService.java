package nl.iprofs.kgb.w3cwidgets.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fibonacci/{number}")
public class FibonacciService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response fibonacci(@PathParam("number") String number) {
		int value;
		try {
			value = Integer.valueOf(number);
		} catch (NumberFormatException nfe) {
			value = 0;
		}
		value = value > 46 ? 46 : value;
		value = value < 0 ? 0 : value;

		List<FibonacciResult> result = doFibonacci(value);
		// add special header to make response work together with jquery
		return Response.ok(toJson(result), MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*").build();

	}

	private List<FibonacciResult> doFibonacci(int number) {
		List<FibonacciResult> result = new ArrayList<FibonacciResult>();
		for (int i = 0; i <= number; i++) {
			if (i == 0) {
				result.add(new FibonacciResult(0, 0));
			} else if (i == 1) {
				result.add(new FibonacciResult(1, 1));
			} else {
				int value = result.get(i - 1).getWaarde() + result.get(i - 2).getWaarde();
				result.add(new FibonacciResult(i, value));
			}
		}
		return result;
	}

	private String toJson(List<FibonacciResult> fibonacciNumbers) {
		StringBuffer result = new StringBuffer("{\"FibonacciReeks\" : [\n");

		for (FibonacciResult resultEntry: fibonacciNumbers) {
			result.append("   {\"n\": ").append(resultEntry.getN()).append(", \"waarde\": ")
					.append(resultEntry.getWaarde()).append(" }")
					.append(resultEntry.getN() < fibonacciNumbers.get(fibonacciNumbers.size()-1).getN() ? "," : "")
					.append("\n");
		}
		result.append("   ]\n}");
		return result.toString();
	}

}
