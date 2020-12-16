package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "customers")
@NamedQueries({
    @NamedQuery(
            name = "getAllCustomers",
            query = "SELECT c FROM Customer AS c"
            ),
    @NamedQuery(
            name = "getCustomersCount",
            query = "SELECT COUNT(c) FROM Customer AS c"
            )
})
@Entity
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false, unique = true)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Lob
    @Column(name = "memo", nullable = false)
    private String memo;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getCompany() {
    return company;
}

public void setCompany(String company) {
    this.company = company;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public Timestamp getCreated_at() {
    return created_at;
}

public void setCreated_at(Timestamp created_at) {
    this.created_at = created_at;
}

public Timestamp getUpdated_at() {
    return updated_at;
}

public void setUpdated_at(Timestamp updated_at) {
    this.updated_at = updated_at;
}

public String getMemo() {
    return memo;
}

public void setMemo(String memo) {
    this.memo = memo;
}
}
