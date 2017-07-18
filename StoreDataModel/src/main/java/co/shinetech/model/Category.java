/*
 * Customer.java
 */
package co.shinetech.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Domain class to transfer Category data between layers.
 * @author rodrigo
 * @since 03/06/2017
 */
@Entity
@Table
public class Category implements Domain<Long>{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(length=30)
    private String name;
    @Column(length=256)
    private String description;
    @ManyToOne
    private Category parent;
    @OneToMany(mappedBy="parent")
    private Collection<Category> children;

    public Category() {
        super();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id == category.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}