package com.ley.springcloud.hystrix.command;

import org.junit.Test;

public class CommandTest {

    @Test
    public void test() {
        Receiver receiver = new Receiver();
        Command command = new HelloCommand(receiver);
        Invoker invoker=new Invoker(command);
        invoker.action(); //客户端通过调用者来执行命令
    }
}
