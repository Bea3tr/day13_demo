package ssf.day13_demo.models;

public class Registration {

    private String name;
    private String email;
    private String comments;

    // property name - name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    // property name - email
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    // property name - comments
    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    @Override
    public String toString() {
        return "Registration [name=" + name + ", email=" + email + ", comments=" + comments + "]";
    }

}