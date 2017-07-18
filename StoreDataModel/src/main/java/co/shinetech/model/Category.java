/*
 * Customer.java
 */
package co.shinetech.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Domain class to transfer Category data between layers.
 * @author rodrigo
 * @since 03/06/2017
 */
@Entity
@Table
@NamedQuery(name="Category.findFirstLevel", query = "SELECT c FROM Category c WHERE c.id NOT IN (SELECT c.id FROM c.children)")
public class Category implements Domain<Long>{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(length=30)
    private String name;
    @Column(length=256)
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> parent;
    @ManyToMany(mappedBy = "parent",fetch = FetchType.LAZY)
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

    public Collection<Category> getParent() {
        return new ArrayList<>(parent);
    }

    public void setParent(Collection<Category> parent) {
        this.parent = parent;
    }

    public Collection<Category> getChildren() {
        return new ArrayList<>(children);
    }

    public void setChildren(Collection<Category> children) {
        this.children = children;
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