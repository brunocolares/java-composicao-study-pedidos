package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		
		Client client = new Client(name, email, birthDate);
		Order order = new Order(new Date(), orderStatus, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer productQuantity = sc.nextInt();
			sc.nextLine();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
		}
		System.out.println("");
		System.out.println(order.toString());
		
	}
}
