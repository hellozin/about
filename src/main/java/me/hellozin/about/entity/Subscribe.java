package me.hellozin.about.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subscribe {

    @Id
    @GeneratedValue
    private long id;

    private long producerId;

    private long consumerId;

    protected Subscribe() {
    }

    public Subscribe(long producerId, long consumerId) {
        this.producerId = producerId;
        this.consumerId = consumerId;
    }

    public long getId() {
        return id;
    }

    public long getProducerId() {
        return producerId;
    }

    public long getConsumerId() {
        return consumerId;
    }
}
