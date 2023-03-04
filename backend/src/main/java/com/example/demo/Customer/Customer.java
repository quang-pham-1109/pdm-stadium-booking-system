package com.example.demo.Customer;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.scheduling.support.SimpleTriggerContext;

@AllArgsConstructor //Add all constructor
@Document(collection = "customer")
public class Customer {
    @Id
    private ObjectId _id;
    private String name;
    private String email;
    private Long index;

    public ObjectId get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getIndex() {
        return index;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndex(Long index) {
        this.index = index;
    }
}
