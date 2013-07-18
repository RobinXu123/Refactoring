package robin.step2;

public class Rental {

	private Movie _movie; // 影片
	private int _daysRented; // 租期

	public Rental(Movie _movie, int _daysRented) {
		super();
		this._movie = _movie;
		this._daysRented = _daysRented;
	}

	public Movie get_movie() {
		return _movie;
	}

	public void set_movie(Movie _movie) {
		this._movie = _movie;
	}

	public int get_daysRented() {
		return _daysRented;
	}

	public void set_daysRented(int _daysRented) {
		this._daysRented = _daysRented;
	}

	double getCharge() {
		double result = 0;
		switch (get_movie().get_priceCode()) { // 取得影片出租价格

		case Movie.REGULAR: // 普通片
			result += 2;
			if (get_daysRented() > 2)
				result += (get_daysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE: // 新片
			result += get_daysRented() * 3;
			break;
		case Movie.CHILDRENS: // 儿童。
			result += 1.5;
			if (get_daysRented() > 3)
				result += (get_daysRented() - 3) * 1.5;
			break;
		}
		return result;
	};
	
	int getFrequentRenterPoints() {
		int result = 0;
		
		result++;

		// add bonus for a two day new release rental
		if ((get_movie().get_priceCode() == Movie.NEW_RELEASE) && get_daysRented() > 1)
			result++;
		
		return result;
	};

}
