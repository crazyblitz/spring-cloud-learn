package com.ley.springcloud.hystrix.command;

public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
