package relation.one_to_one;

import jakarta.persistence.*;

import java.io.Serializable;

    @Entity
    @Table (name = "employee", schema = "hibernate")
    public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column
    private String salary;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public Employee() {
    }

    public Employee(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
