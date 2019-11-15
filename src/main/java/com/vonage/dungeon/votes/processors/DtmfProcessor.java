package com.vonage.dungeon.votes.processors;

import com.vonage.dungeon.votes.domain.Counters;
import com.vonage.dungeon.votes.domain.Dtmf;
import org.springframework.stereotype.Component;

@Component
public class DtmfProcessor {
    public void process(Dtmf dtmf) {
        switch (dtmf.getDigit()) {
            case "2":
                Counters.up.incrementAndGet();
                System.out.println("2");
                break;
            case "8":
                Counters.down.incrementAndGet();
                System.out.println("8");
                break;
            case "4":
                Counters.left.incrementAndGet();
                System.out.println("4");
                break;
            case "6":
                Counters.right.incrementAndGet();
                System.out.println("6");
                break;
        }
    }
}
