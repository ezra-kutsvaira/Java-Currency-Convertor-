package currrencyConvertor;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
public class CurrencyConvertor {
	private static final  DecimalFormat f = new DecimalFormat("##.##");
	
		public static void main(String... args) {
			
			System.out.println("__________________________________");
			System.out.println(" JAVA CURRENCY CONVERTOR ");
			System.out.println(" __________________________________");
			
			//User input 
			Scanner scanner = new Scanner(System.in);
			
			//Get user's choice of currency
			System.out.println("Choose the currency you want to convert from the choices below ");
			List<String> currencyOptions = Arrays.asList("1.USD, 2.POUND, 3.EURO, 4.Yen, 5.ZAR");
			currencyOptions.forEach(option -> System.out.println(option));
			int choice = scanner.nextInt();
			
			//Get the amount to be converted
			System.out.println("Enter the amount you want to convert");
			double amount = scanner.nextDouble();
			
			//Calculate the converted amount
			double convertedAmount = currencyOptions.stream()
					.mapToDouble(option -> getConvertedAmount(option, choice))
					.findFirst()
					.orElse(0.0);
						
			//Print the converted amount
			String currencyOption = currencyOptions.get( choice -1);
			if (choice > currencyOptions.size() || choice < 1) {
				System.out.println("Invalid choice. Please choose a number between 1 and " + (currencyOptions.size() - 1));
				return ;
				}
			System.out.println(amount + " " + currencyOption + " = " + f.format(convertedAmount) + " " + currencyOptions.get(0));
			
			
			double convertedAmount = switch (choice) {
		    case 1 -> getConvertedAmount("Dollar", amount);
		    case 2 -> getConvertedAmount("Pound", amount);
		    case 3 -> getConvertedAmount("Euro", amount);
		    case 4 -> getConvertedAmount("Yen", amount);
		    case 5 -> getConvertedAmount("Rand", amount);
		    default -> {
		        System.out.println("Invalid choice. Please choose a number between 1 and " + currencyOptions.size());
		        yield 0;
		    }
		};

		
		scanner.close();	
		}

		private static double getConvertedAmount(String currencyName, double amount) {
		    double usd, pound, euro, yen, zar;
		    double convertedAmount = 0;

		    switch (currencyName) {
		        case "Dollar" -> {
		            pound = amount * 88;
		            System.out.println(amount + " Dollar = " + f.format(pound) + " Pound");

		            euro = amount * 80;
		            System.out.println(amount + " Dollar = " + f.format(euro) + " Euro");

		            yen = amount * 0.63;
		            System.out.println(amount + " Dollar = " + f.format(yen) + " Yen");

		            zar = amount * 16;
		            System.out.println(amount + " Dollar = " + f.format(zar) + " Rand");

		            convertedAmount = pound;
		        }
		        case "Pound" -> {
		            usd = amount * 88;
		            System.out.println(amount + " Pound = " + f.format(usd) + " Dollar");

		            euro = amount * 80;
		            System.out.println(amount + " Pound = " + f.format(euro) + " Euro");

		            yen = amount * 0.63;
		            System.out.println(amount + " Pound = " + f.format(yen) + " Yen");

		            zar = amount * 16;
		            System.out.println(amount + " Pound = " + f.format(zar) + " Rand");

		            convertedAmount = usd;
		        }
		        case "Euro" -> {
		            usd = amount * 88;
		            System.out.println(amount + " Euro = " + f.format(usd) + " Dollar");

		            pound = amount * 80;
		            System.out.println(amount + " Euro = " + f.format(pound) + " Pound");

		            yen = amount * 0.63;
		            System.out.println(amount + " Euro = " + f.format(yen) + " Yen");

		            zar = amount * 16;
		            System.out.println(amount + " Euro = " + f.format(zar) + " Rand");

		            convertedAmount = usd;
		        }
		        case "Yen" -> {
		            usd = amount * 88;
		            System.out.println(amount + " Yen = " + f.format(usd) + " Dollar");

		            pound = amount * 80;
		            System.out.println(amount + " Yen = " + f.format(pound) + " Pound");

		            euro = amount * 0.63;
		            System.out.println(amount + " Yen = " + f.format(euro) + " Euro");

		            zar = amount * 16;
		            System.out.println(amount + " Yen = " + f.format(zar) + " Rand");

		            convertedAmount = usd;
		        }
		        case "Rand" -> {
		            usd = amount * 88;
		            System.out.println(amount + " Rand = " + f.format(usd) + " Dollar");

		            pound = amount * 80;
		            System.out.println(amount + " Rand = " + f.format(pound) + " Pound");

		            euro = amount * 0.63;
		            System.out.println(amount + " Rand = " + f.format(euro) + " Euro");

		            yen = amount * 16;
		            System.out.println(amount + " Rand = " + f.format(yen) + " Yen");

		            convertedAmount = usd;
		        }
		    }
		    return convertedAmount;
		}
	
}
