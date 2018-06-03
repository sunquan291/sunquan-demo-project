package com.zte.sunquan.demo.akk.event;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.zte.sunquan.demo.akka.event.APerson;
import com.zte.sunquan.demo.akka.event.HelloEvent;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EventTest {

    @Test
    public void testEvent() throws InterruptedException {
        ActorSystem system = ActorSystem.create("akka-event-test");
        ActorRef aPerson = system.actorOf(APerson.props());
        //注意这里加延迟是由于Actor的创建是异步，防止消息发送在Actor创建好之前
        TimeUnit.SECONDS.sleep(1);
        HelloEvent event = new HelloEvent();
        event.setId(1);
        event.setMsg("hello,world");
        system.eventStream().publish(event);
        TimeUnit.SECONDS.sleep(4);
    }
}
