package com.petstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Entity class for pet.
 * <p>
 * User: Ionut Barau (ionutbarau)
 * Project: petstore
 * Date: 21/04/2017.
 * Time: 16:25
 */
@Entity
public class Pet implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1180327771714233289L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    /** The pet id. */
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category")
    /** The pet category. */
    private Category category;

    @Column(name = "name")
    /** The pet name. */
    private String name;

    @ElementCollection
    @CollectionTable(name = "photo_urls")
    @Column(length = 10000)
    /** The list of photos for this pet instance. */
    private Set<String> photoUrls;

    @ManyToMany
    @JoinTable(
            name = "PETS_TAGS",
            joinColumns = @JoinColumn(name = "pet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    /** The list of tags used for retrieving this pet instance. */
    private Set<Tag> tags;

    @Column(name = "status")
    /** The availability status. */
    private String status;

    /**
     * Default no-arg constructor.
     */
    public Pet() {
    }

    /**
     * Public constructor with all the fields as arguments.
     *
     * @param id
     * @param category
     * @param name
     * @param photoUrls
     * @param tags
     * @param status
     */
    public Pet(Integer id, Category category, String name, Set<String> photoUrls, Set<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(Set<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Generated by Intellij
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (id != null ? !id.equals(pet.id) : pet.id != null) return false;
        if (category != null ? !category.equals(pet.category) : pet.category != null) return false;
        if (name != null ? !name.equals(pet.name) : pet.name != null) return false;
        if (photoUrls != null ? !photoUrls.equals(pet.photoUrls) : pet.photoUrls != null) return false;
        if (tags != null ? !tags.equals(pet.tags) : pet.tags != null) return false;
        return status != null ? status.equals(pet.status) : pet.status == null;

    }

    //Generated by Intellij
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photoUrls != null ? photoUrls.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    //Generated by Intellij
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
