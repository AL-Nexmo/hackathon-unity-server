package com.vonage.dungeon.votes.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping()
public class NccoController {

    @Autowired
    ResourceLoader resourceLoader;

    @PostMapping(value = "/ncco", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection> returnNcco() {

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = String.class.getResourceAsStream("/ncco.json");
        try {
            Collection test = mapper.readValue(is, Collection.class);
            System.out.println(test);
            return ResponseEntity.ok(test);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
