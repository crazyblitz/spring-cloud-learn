package com.ley.springcloud.hystrix.command;

public class HelloCommand implements Command {

    private Receiver receiver;

    public HelloCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
        System.out.println("Hello Command");
    }
}
