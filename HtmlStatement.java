import java.util.Enumeration;

public class HtmlStatement extends Statement {
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
     return "<H1>Rentals for <EM>" + aCustomer.getName() +
      "</EM></H1><P>\n";
   }

   private String body(Rental each) {
     return each.getMovie().getTitle()+ ": " +
         String.valueOf(each.getCharge()) + "<BR>\n";
   }

   private String footer(Customer aCustomer) {
    String footer = "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
    
    footer += "On this rental you earned <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";

    return footer;
   }

}