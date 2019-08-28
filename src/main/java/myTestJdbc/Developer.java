package myTestJdbc;

public class Developer {
    private int id;
    private String developer;
    private String skills;
    private String companies;
    private int salary;

    public Developer(){}

    public Developer(int id, String developer, String skills, String companies, int salary) {
        this.id = id;
        this.developer = developer;
        this.skills = skills;
        this.companies = companies;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", developer='" + developer + '\'' +
                ", skills='" + skills + '\'' +
                ", companies='" + companies + '\'' +
                ", salary=" + salary +
                '}';
    }
}
