package com.functinal.programming.basics;

import lombok.extern.slf4j.Slf4j;

/**
 * Functional Interface :
 *  Interface Having single abstract method
 */
@Slf4j
public class FirstFunctionalInterface {

    public static void main(String[] args) {
        /**
         * Return type of Lambda is the Interface
         */
      SayHello hello =  name -> log.info("Hello {}", name);
      hello.say("Raja");

      SayBye bye = name -> log.info("Bye {}", name);
      bye.say("Raja");

        /**
         * Can Pass Function Body (Lambda) as an argument
         */
      invite(name -> log.info("Hello {}", name));
      sendOut(name -> log.info("Bye {}", name));
    }

    /**
     * Higher Order functions taking Function/Behaviour as an argument
     * @param hello
     */
    static void invite(SayHello hello) {
        hello.say("Rani");
    }

    /**
     * Higher Order functions taking Function/Behaviour as an argument
     * @param bye
     */
    static void sendOut(SayBye bye) {
        bye.say("Rani");
    }

    /**
     * It is a Functional Interface as long as if it has ONLY ONE Abstract method
     */
    interface SayHello {
        void say(String name);
    }

    /**
     * Added @FunctionalInterface annotation to the single abstract method interface,
     * Due to this Compiller will throw Error if we try to add other abstract methods
     */
    @FunctionalInterface
    interface SayBye {
        void say(String name);
    }
}
