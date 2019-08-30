package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<String>();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String line = bufferedReader.readLine();
		String[] lineItems = new String[line.length()];

		for (int I = 0; I < line.length(); I++) {
			lineItems[I] = "" + line.charAt(I);
		}

		stack.push("-1");

		int longitudSubcadenaMasLarga = 0;
		int totalCadenas = 0;

		for (int I = 0; I < line.length(); I++) {
			if (lineItems[I].equals("(")) {
				stack.push("" + I);
			} else if (lineItems[I].equals(")")) {
				stack.pop();
				if (!stack.isEmpty()) {
					int subCadenaValidaACtual = I - Integer.parseInt(stack.peek());
					if (subCadenaValidaACtual > longitudSubcadenaMasLarga) {
						longitudSubcadenaMasLarga = subCadenaValidaACtual;
						totalCadenas = 1;
					} else if (subCadenaValidaACtual == longitudSubcadenaMasLarga) {
						totalCadenas++;
					}
				} else {
					stack.push(I + "");
				}
			}
		}

		if (totalCadenas == 0) {
			System.out.println("0 1");
		} else {
			System.out.println(longitudSubcadenaMasLarga + " " + totalCadenas);
		}
	}
}