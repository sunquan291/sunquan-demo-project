package com.zte.sunquan.demo.akka.type;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

import static akka.actor.SupervisorStrategy.*;

public class ChildTypeActor implements Child {
    @Override
    public void child() {

    }
}