package org.medmota.views;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FirstBean {

	private String input;
	private String output;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void submit() {
		output = "Hello World! You have typed: " + input;
	}
}
