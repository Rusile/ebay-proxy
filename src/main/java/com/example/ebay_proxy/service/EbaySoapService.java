package com.example.ebay_proxy.service;

import com.example.ebay_proxy.model.DecreasePriceRequest;
import com.example.ebay_proxy.model.IncreasePriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class EbaySoapService {

    private final WebServiceTemplate webServiceTemplate;
    private final String url;

    @Autowired
    public EbaySoapService(
            WebServiceTemplate webServiceTemplate,
            @Value("${prop.ebay.service.url}") String url
    ) {
        this.webServiceTemplate = webServiceTemplate;
        this.url = url;
    }

    public void increasePrice(float pricePercent) {
        IncreasePriceRequest request = new IncreasePriceRequest();
        request.setPricePercent(pricePercent);

        webServiceTemplate
                .marshalSendAndReceive(
                        url,
                        request,
                        new SoapActionCallback(url + "/IncreasePriceRequest")
                );
    }

    public void decreasePrice(float pricePercent) {
        DecreasePriceRequest request = new DecreasePriceRequest();
        request.setPricePercent(pricePercent);

        webServiceTemplate
                .marshalSendAndReceive(
                        url,
                        request,
                        new SoapActionCallback("http://188.225.56.32:8080/ebay-service/ws" + "/DecreasePriceRequest")
                );
    }
}
