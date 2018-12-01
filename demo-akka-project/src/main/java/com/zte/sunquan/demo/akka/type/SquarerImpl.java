package com.zte.sunquan.demo.akka.type;

import akka.actor.*;
import akka.japi.Creator;
import akka.pattern.Patterns;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class SquarerImpl implements Squarer, akka.actor.TypedActor.Receiver{
    private String name;
    private ActorSystem system;

    public SquarerImpl() {
        this.name = "default";
    }

    public SquarerImpl(String name, ActorSystem system) {
        this.name = name;
        this.system=system;
    }
    @Override
    public void onReceive(Object message, ActorRef sender) {

    }

    @Override
    public void squareDontCare(int i) {
        ActorSelection actorSelection = system.actorSelection("akka://type-actor-test/user/ch");
        if(!actorSelection.anchor().isTerminated()){
            Future<Boolean> booleanFuture = Patterns.gracefulStop(actorSelection.anchor(), Duration.create(15, TimeUnit.SECONDS));
            FutureConverters.toJava(booleanFuture).whenComplete((p,e)->{
                System.out.println("aaaaaaaaaaaa");
                if(e!=null){
                    System.out.println(e);
                }else {
                    System.out.println(p);
                    System.out.println(system.actorSelection("akka://type-actor-test/user/ch").anchor().isTerminated());
                    Child child=TypedActor.get(system)
                            .typedActorOf(new TypedProps<ChildTypeActor>(Child.class,
                                            new Creator<ChildTypeActor>() {
                                                public ChildTypeActor create() {
                                                    return new ChildTypeActor();
                                                }  //这里创建的是具体的实现类型
                                            }),
                                    "ch");
                }
            });
        }
    }
}
