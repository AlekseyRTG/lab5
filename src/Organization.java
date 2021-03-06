public class Organization {
    private long id; //
    private String name;
    private String fullName;
    private OrganizationType type;
    private Address postalAddress;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public OrganizationType getType() {return type;}
    public void setType(OrganizationType type) {this.type = type;}

    public Address getPostalAddress() {return postalAddress;}
    public void setPostalAddress(Address postalAddress) {this.postalAddress = postalAddress; }
}

