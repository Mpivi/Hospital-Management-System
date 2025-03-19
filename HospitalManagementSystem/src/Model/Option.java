package Model;

import java.util.Scanner;

public interface Option {
	
	abstract void operation(Scanner s, Database database, User u);
	abstract String getName();

}
