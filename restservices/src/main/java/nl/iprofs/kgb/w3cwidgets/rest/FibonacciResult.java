package nl.iprofs.kgb.w3cwidgets.rest;

public class FibonacciResult {
	private int n;
	private int waarde;
	
	public FibonacciResult(int n, int waarde) {
		this.n = n;
		this.waarde = waarde;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getWaarde() {
		return waarde;
	}
	public void setWaarde(int waarde) {
		this.waarde = waarde;
	}

}
