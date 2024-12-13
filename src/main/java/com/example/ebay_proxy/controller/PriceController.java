package com.example.ebay_proxy.controller;

import com.example.ebay_proxy.service.EbaySoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
@Validated
public class PriceController {

    private final EbaySoapService service;

    @Autowired
    public PriceController(EbaySoapService service) {
        this.service = service;
    }

    @PostMapping("/increase/{increasePercent}")
    public ResponseEntity<Void> increasePrice(@PathVariable("increasePercent") float percent) {
        service.increasePrice(percent);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/decrease/{decreasePercent}")
    public ResponseEntity<Void> decreasePrice(@PathVariable("decreasePercent") float percent) {
        service.decreasePrice(percent);
        return ResponseEntity.ok().build();
    }
}