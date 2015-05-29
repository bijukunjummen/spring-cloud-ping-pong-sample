package org.bk.producer.domain;


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
}
