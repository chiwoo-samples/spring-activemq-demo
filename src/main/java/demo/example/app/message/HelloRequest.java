package demo.example.app.message;

public class HelloRequest {

    private String name;
    private String greeting;

    public HelloRequest() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                ", greeting='" + greeting + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloRequest hello = (HelloRequest) o;
        if (name != null ? !name.equals(hello.name) : hello.name != null) return false;
        return greeting != null ? greeting.equals(hello.greeting) : hello.greeting == null;
    }

    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (greeting != null ? greeting.hashCode() : 0);
        return result;
    }
}
