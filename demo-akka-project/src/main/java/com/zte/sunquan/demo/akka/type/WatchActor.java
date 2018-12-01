package com.zte.sunquan.demo.akka.type;

import akka.actor.AbstractActor;
import akka.actor.Terminated;

public class WatchActor extends AbstractActor {
    @Override
    public void preStart() throws Exception {
        super.preStart();
        getContext().watch(getContext().getSystem()
                .actorSelection("akka://type-actor-test/user/ch").anchor());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Terminated.class, p -> {
                    System.out.println(p);
                })
                .matchAny(p->{
                    System.out.println(p);
                })
                .build();
    }
}
