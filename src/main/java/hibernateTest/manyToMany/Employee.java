package hibernateTest.manyToMany;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @ManyToMany
    @JoinTable(name = "EmployeeProject",joinColumns = {
            @JoinColumn(name = "employee_id")
    },inverseJoinColumns = {
            @JoinColumn(name = "project_id")
    } )
    private Set<Project> projects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
