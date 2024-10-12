package com.learning.passwordmanager.passwordmgmtservice.model;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.hibernate.generator.EventTypeSets;

import java.util.EnumSet;
import java.util.Random;


public class NanoIdGeneratorImpl implements BeforeExecutionGenerator {
    private String prefix;
    private long lb = 1000L;
    private long ub = 10000L;

    public NanoIdGeneratorImpl(NanoIdGenerator generatorConfig) {
        this.prefix = generatorConfig.prefix();
    }

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o, Object o1, EventType eventType) {
        return prefix + "-" + System.nanoTime() + new Random().nextLong(lb,ub);
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EventTypeSets.INSERT_ONLY;
    }
}
