import java.util.Enumeration;

public class TextStatement extends Statement {
   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = header(aCustomer);
      
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += body(each);
      }

      //add footer lines
      result += footer(aCustomer);
      
      return result;
   }

   private String header(Customer aCustomer) {
     return "Rental Record for " + aCustomer.getName() + "\n";
   }

   private String body(Rental each) {
     return "\t" + each.getMovie().getTitle()+ "\t" +
        String.valueOf(each.getCharge()) + "\n";
   }

   private String footer(Customer aCustomer) {
    String footer = "Amount owed is " + 
    String.valueOf(aCustomer.getTotalCharge()) + "\n";

    footer += "You earned " + 
    String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      " frequent renter points";

    return footer;
   }
}