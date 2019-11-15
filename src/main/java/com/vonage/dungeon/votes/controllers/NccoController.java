package com.vonage.dungeon.votes.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class NccoController {

    @GetMapping(value = "/ncco", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> returnNcco() {

        String blah = "[\n" +
            "  {\n" +
            "    \"action\": \"talk\",\n" +
            "    \"text\": \"Go go go\",\n" +
            "    \"bargeIn\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"action\": \"input\",\n" +
            "    \"eventUrl\": [\"http://dungeon-one-hack-server.herokuapp.com/dtmf\"],\n" +
            "    \"timeOut\": 10,\n" +
            "    \"maxDigits\": 1\n" +
            "  }\n" +
            "]";

        return ResponseEntity.ok(blah);
    }
}
