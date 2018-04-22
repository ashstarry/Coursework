/**
   Describes a mailing address.
*/
public class Address
{  
   private String name;
   private String street;
   private String city;
   private String state;
   private String zip;

   /**
      Constructs a mailing address. 
      @param aName the recipient name
      @param aStreet the street
      @param aCity the city
      @param aState the two-letter state code
      @param aZip the ZIP postal code
   */
   public Address(String aName, String aStreet,
         String aCity, String aState, String aZip)
   {  
      name = aName;
      street = aStreet;
      city = aCity;
      state = aState;
      zip = aZip;
   } 
   
   /**
    * Provides the recipient's name for invoice formatting
    * @return name
    */
   public String getName()
   {
	   return name;
   }

   /**
    * Provides the recipient's street for invoice formatting
    * @return street
    */
   public String getStreet()
   {
	   return street;
   }
   
   /**
    * Provides the recipient's city for invoice formatting
    * @return city
    */
   public String getCity()
   {
	   return city;
   }
   
   /**
    * Provides the recipient's state for invoice formatting
    * @return state
    */
   public String getState()
   {
	   return state;
   }
   
   /**
    * Provides the recipient's zip code for invoice formatting
    * @return zip
    */
   public String getZip()
   {
	   return zip;
   }
   
}

