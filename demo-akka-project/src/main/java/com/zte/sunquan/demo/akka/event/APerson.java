package com.zte.sunquan.demo.akka.event;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class APerson extends AbstractActor {
    @Override
    public void preStart() throws Exception {
//        getContext().getSystem().eventStream().subscribe(getSelf(), HelloEvent.class);
        super.preStart();
    }

    public static Props props() {
        return Props.create(APerson.class);
    }

    @Override
    public Receive createReceive() {

        return receiveBuilder()
                .match(HelloEvent.class, p -> {
                    System.out.println(p.getId() + ":" + p.getMsg());
                })
                .build();
    }
}
