package designexamples.fooddeliveryapp.data;
public class Address {

    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;

    public Address(AddressBuilder addressBuilder){
    this.addressLine1=addressBuilder.addressLine1;
    this.addressLine2=addressBuilder.addressLine2;
    this.addressLine3=addressBuilder.addressLine3;
    this.city=addressBuilder.city;
    this.country=addressBuilder.country;
    this.state=addressBuilder.state;
    this.zip=addressBuilder.zip;

    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    private static class AddressBuilder{
        private  String addressLine1;
        private  String addressLine2;
        private  String addressLine3;
        private  String city;
        private  String state;
        private  String zip;
        private  String country;

        public AddressBuilder(String addressLine1, String addressLine2, String addressLine3, String city, String state, String zip, String country) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.addressLine3 = addressLine3;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.country = country;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public String getAddressLine3() {
            return addressLine3;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZip() {
            return zip;
        }

        public String getCountry() {
            return country;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public void setAddressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }


   }
