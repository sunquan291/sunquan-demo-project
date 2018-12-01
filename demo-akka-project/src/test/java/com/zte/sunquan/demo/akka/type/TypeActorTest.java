package com.zte.sunquan.demo.akka.type;

import akka.actor.*;
import akka.japi.Creator;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

public class TypeActorTest {
    @Test
    public void test() {
        ActorSystem system = ActorSystem.create("type-actor-test");

        Squarer otherSquarer =
                TypedActor.get(system)
                        .typedActorOf(new TypedProps<SquarerImpl>(Squarer.class,
                                        new Creator<SquarerImpl>() {
                                            public SquarerImpl create() {
                                                return new SquarerImpl("pt", system);
                                            }  //这里创建的是具体的实现类型
                                        }),
                                "pt");
        otherSquarer.squareDontCare(1);
        ActorRef watch = system.actorOf(Props.create(WatchActor.class), "watch");
        otherSquarer.squareDontCare(1);
        otherSquarer.squareDontCare(1);
        otherSquarer.squareDontCare(1);
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
