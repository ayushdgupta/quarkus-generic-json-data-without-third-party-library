package com.guptaji.entity;

import com.guptaji.util.HashMapConverter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;

@Entity
public class GenericJsonTestingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gendre;
    private int age;

    /*
        In below one e.g. is given that how we can send the data to our API

        {
          "name": "Ayush",
          "gendre": "M",
          "age": 10,
          "customJson": {
            "Anime": ["Naruto", "DBZ", "Boruto"],
            "education": {
                 "B.Tech" : {
                     "College" : "HCST",
                     "Branch" : "CSE"
                  },
                  "M.Tech" : {
                     "College" : "NIT RKL",
                     "Branch" : "CSE"
                  }
             }
          }
        }
     */
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> customJson;

    public GenericJsonTestingEntity() {
        // default constructor
    }

    public GenericJsonTestingEntity(Long id, String name, String gendre, int age, Map<String, Object> customJson) {
        this.id = id;
        this.name = name;
        this.gendre = gendre;
        this.age = age;
        this.customJson = customJson;
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

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Object> getCustomJson() {
        return customJson;
    }

    public void setCustomJson(Map<String, Object> customJson) {
        this.customJson = customJson;
    }

    @Override
    public String toString() {
        return "GenericJsonTestingEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gendre='" + gendre + '\'' +
                ", age=" + age +
                ", customJson=" + customJson +
                '}';
    }
}
