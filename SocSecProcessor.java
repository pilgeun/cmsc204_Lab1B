import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String[] args) throws SocSecException  {
		// TODO Auto-generated method stub
		String name, ssn;
		char again;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.print("Name? ");
			name = keyboard.nextLine();
			
			System.out.print("SSN? ");
			ssn = keyboard.nextLine();
			
			try {
				if(isValid(ssn))
					System.out.println(name + " " + ssn + " is valid");
				
			} catch (SocSecException e) {
				System.out.println(e);
			}
			
			System.out.print("Continue? ");
			again = Character.toLowerCase(keyboard.next().charAt(0));	
			keyboard.nextLine();	
				
		} while (again == 'y');
		
		
		keyboard.close(); 
	}
	
	
	public static boolean isValid(String ssn) throws SocSecException {
		
		boolean value = true;
		
		if (ssn.length() != 11) {	// check if SSN is 11 characters long
			value = false;
			throw new SocSecException(", wrong number of characters");
		}
			
		
		else if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {	// check if dashes are in the right place
			value = false;
			throw new SocSecException(", dashes at wrong positions");
		}
			
		else
			for(int i = 0; i < ssn.length(); i++) {
				if (i == 3 || i == 6)	// skip dashes
					continue;
				else
					if ( !Character.isDigit(ssn.charAt(i)) )
					{
						value = false;
						throw new SocSecException(", contains a character that is not a digit");
					}
			}

		return value;
	}

}
