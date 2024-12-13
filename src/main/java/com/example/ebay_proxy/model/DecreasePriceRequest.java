package com.example.ebay_proxy.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DecreasePriceRequest", namespace = "http://188.225.56.32:8080/ebay-service/ws")
@XmlAccessorType(XmlAccessType.FIELD)
public class DecreasePriceRequest {

    @XmlElement(name = "pricePercent", namespace = "http://188.225.56.32:8080/ebay-service/ws")
    private Float pricePercent;

    public DecreasePriceRequest() {
    }

    public DecreasePriceRequest(Float pricePercent) {
        this.pricePercent = pricePercent;
    }

    public Float getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(Float pricePercent) {
        this.pricePercent = pricePercent;
    }
}