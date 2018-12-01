package com.zte.sunquan.demo.akka.event;

import akka.actor.ActorRef;
import akka.event.japi.LookupEventBus;

public class LookUpBusImpl extends LookupEventBus<HelloEvent,ActorRef,String> {
    @Override
    public int mapSize() {
        return 128;
    }

    @Override
    public int compareSubscribers(ActorRef a, ActorRef b) {
        return a.compareTo(b);
    }

    @Override
    public String classify(HelloEvent event) {
        return String.valueOf(event.getId());
    }

    @Override
    public void publish(HelloEvent event, ActorRef subscriber) {
        subscriber.tell(event,ActorRef.noSender());
    }
}
