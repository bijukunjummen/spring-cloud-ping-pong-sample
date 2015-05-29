package org.bk.consumer.domain;


public class Message {
    private String id;
    private String payload;

    public Message() {

    }

    public Message(String id, String payload) {
        this.id = id;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
