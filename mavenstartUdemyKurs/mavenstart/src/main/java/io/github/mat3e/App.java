package io.github.mat3e;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;

 class SayHello { private final Logger logger = LoggerFactory.getLogger(SayHello.class);

    private void sayHello() { logger.info("hello");}

    public static void main(String args[]) { SayHello scanner = new SayHello(); scanner.sayHello(); }

}