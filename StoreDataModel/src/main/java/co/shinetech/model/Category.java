/*
 * Customer.java
 */
package co.shinetech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@NamedQueries({
    @NamedQuery(name="Category.findFirstLevel", query = "SELECT c FROM Category c WHERE c.id NOT IN (SELECT c.id FROM c.parent)")
})
@NamedNativeQueries({
  @NamedNativeQuery(name = "Category.findSubCategories", query = "SELECT c.* FROM category c INNER JOIN category_parent cp ON (c.id = cp.children_id) WHERE cp.parent_id = ?1",resultClass = Category.class)
})
public class Category implements Domain<Long>{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(length=30)
    private String name;
    @Column(length=256)
    private String description;
    @JsonIgnore
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