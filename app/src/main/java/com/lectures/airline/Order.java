package com.lectures.airline;

import java.io.Serializable;

public class Order implements Serializable {

    private String destination;
    private String name;
    private int age;
    private int NOP;
    private boolean bornInIsrael;


    private Order(OrderBuilder builder) {
        this.destination = builder.destination;
        this.name = builder.name;
        this.age = builder.age;
        this.NOP = builder.NOP;
        this.bornInIsrael = builder.bornInIsrael;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNOP(int NOP) {
        this.NOP = NOP;
    }

    public void setBornInIsrael(boolean bornInIsrael) {
        this.bornInIsrael = bornInIsrael;
    }

    public String getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNOP() {
        return NOP;
    }

    public boolean isBornInIsrael() {
        return bornInIsrael;
    }

    public static class OrderBuilder
    {
        private final String destination;
        private String name;
        private int age;
        private final int NOP;
        private boolean bornInIsrael;

        public OrderBuilder(String destination,int NOP,boolean BornInIsrael) {
            this.destination = destination;
            this.NOP = NOP;
            this.bornInIsrael = bornInIsrael;
        }
        public OrderBuilder age(int age) {
            this.age = age;
            return this;
        }
        public OrderBuilder name(String name) {
            this.name = name;
            return this;
        }
        public Order build() {
            Order order =  new Order(this);

            return order;
        }

    }
}
