package com.vonage.dungeon.votes.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoMessage {

    private String type;
    private String to;
    private String msisdn;
    private String messageId;
    private String messageTimestamp;
    private String timestamp;
    private String nonce;
    private String text;
    private String keyword;

    @JsonCreator
    public MoMessage(@JsonProperty("type") String type,
                     @JsonProperty("to") String to,
                     @JsonProperty("msisdn") String msisdn,
                     @JsonProperty("messageId") String messageId,
                     @JsonProperty("message-timestamp") String messageTimestamp,
                     @JsonProperty("timestamp") String timestamp,
                     @JsonProperty("nonce") String nonce,
                     @JsonProperty("text") String text,
                     @JsonProperty("keyword") String keyword) {
        this.type = type;
        this.to = to;
        this.msisdn = msisdn;
        this.messageId = messageId;
        this.messageTimestamp = messageTimestamp;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.text = text;
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(String messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "MoMessage{" +
                "type='" + type + '\'' +
                ", to='" + to + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messageTimestamp='" + messageTimestamp + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", text='" + text + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
