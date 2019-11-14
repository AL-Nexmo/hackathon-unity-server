package com.vonage.dungeon.votes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vonage.dungeon.votes.domain.Dtmf;
import com.vonage.dungeon.votes.processors.DtmfProcessor;


@RestController
@RequestMapping()
public class DtmfController {

    private final DtmfProcessor dtmfProcessor;

    @Autowired
    public DtmfController(DtmfProcessor dtmfProcessor) {
        this.dtmfProcessor = dtmfProcessor;
    }

    @PostMapping("/dtmf")
    public ResponseEntity<String> collectDtmf(@RequestBody Dtmf dtmf) {
        dtmfProcessor.process(dtmf);
        return ResponseEntity.ok().build();
    }
}
