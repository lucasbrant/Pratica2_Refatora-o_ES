public class Movie {

  public static final int  CHILDRENS = 2;
  public static final int  REGULAR = 0;
  public static final int  NEW_RELEASE = 1;

  private String _title;
  private int _priceCode;

  public Movie(String title, int priceCode) {
      _title = title;
      _priceCode = priceCode;
  }

  public int getPriceCode() {
      return _priceCode;
  }

  public void setPriceCode(int arg) {
      _priceCode = arg;
  }

  public String getTitle (){
      return _title;
  }

  public double getCharge(int DaysRented) {
    int thisAmount = 0;

    switch(getPriceCode()) {
      case REGULAR:
        thisAmount += 2;
        if (DaysRented > 2)
          thisAmount += (DaysRented - 2) * 1.5;
          break;
      case NEW_RELEASE:
        thisAmount += DaysRented * 3;
        break;
      case CHILDRENS:
        thisAmount += 1.5;
        if (DaysRented > 3)
          thisAmount += (DaysRented - 3) * 1.5;
          break;
    }

    return thisAmount;
  }
  
  public int getFrequentRenterPoints(int daysRented){
    int frequentRenterPoints = 1;
      // add bonus for a two day new release rental
    if ((getPriceCode() == NEW_RELEASE) &&
      daysRented > 1) frequentRenterPoints ++;

    return frequentRenterPoints;
  }

}