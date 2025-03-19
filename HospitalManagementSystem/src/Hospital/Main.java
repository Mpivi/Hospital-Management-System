package Hospital;

import java.util.Scanner;

import Model.Database;
import View.Login;

public class Main {
	
	public static void main(String[] args) {
		new Login(new Scanner(System.in), new Database());
	}

}
