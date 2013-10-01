package nl.iprofs.kgb.w3cwidgets.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SquareResult {
	private int result;

	public SquareResult(int result) {
		this.result = result;
	}

	public SquareResult() {}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
