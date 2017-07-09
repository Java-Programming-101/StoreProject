/*
 * Customer.java
 */
package co.shinetech.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Domain class to transfer Category data between layers.
 * @author rodrigo
 * @since 03/06/2017
 */
@Data
@Entity
@Table
public class Category implements Domain<Long>{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(length=30)
    private String name;
    @Column(length=50)
    private String description;
    @ManyToOne
    private Category parent;
    @OneToMany(mappedBy="parent")
    private Collection<Category> children;

    public Category(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}