package robin.step2;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String _name) {
		super();
		this._name = _name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String statement() {

		Enumeration rentals = _rentals.elements();

		String result = "Rental Record for " + get_name() + "\n";

		while (rentals.hasMoreElements()) {

			Rental each = (Rental) rentals.nextElement(); // 取得一笔租借记。

			// show figures for this rental（显示此笔租借记录）

			result += "\t" + each.get_movie().get_title() + "\t" +

						String.valueOf(each.getCharge()) + "\n";

		}

		// add footer lines（结尾打印）

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";

		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +

		" frequent renter points";

		return result;

	}
	
	public String htmlStatement() {
		Enumeration rentals = _rentals.elements();
		String result = "<h1>Rental Record for <em>" + get_name() + "</em></h1><p>\n";
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement(); // 取得一笔租借记。
			
			// show figures for this rental（显示此笔租借记录）

			result += each.get_movie().get_title() + ":" +

						String.valueOf(each.getCharge()) + "<br>\n";
		}
		
		// add footer lines（结尾打印）

		result += "<p>Amount owed is <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";

		result += "You earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) +

		"</em> frequent renter points<p>";

		return result;
	}
	
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}
