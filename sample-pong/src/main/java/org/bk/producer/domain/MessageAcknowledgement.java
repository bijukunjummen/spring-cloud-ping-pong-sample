package org.bk.producer.domain;


import java.util.Objects;

public class MessageAcknowledgement {

    private String id;
    private String received;
    private String payload;

    public MessageAcknowledgement() {

    }

    public MessageAcknowledgement(String id, String received, String payload) {
        this.id = id;
        this.received = received;
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

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "MessageAcknowledgement{" +
                "id='" + id + '\'' +
                ", received='" + received + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageAcknowledgement that = (MessageAcknowledgement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(received, that.received) &&
                Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, received, payload);
    }
}
