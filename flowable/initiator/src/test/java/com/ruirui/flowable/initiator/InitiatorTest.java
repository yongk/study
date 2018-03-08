package com.ruirui.flowable.initiator;

import org.flowable.engine.common.api.FlowableException;
import org.flowable.engine.common.impl.javax.el.PropertyNotFoundException;
import org.flowable.engine.impl.test.PluggableFlowableTestCase;
import org.flowable.engine.test.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Copy from flowable project InitiatorTest
 */
public class InitiatorTest extends PluggableFlowableTestCase {

    Logger log = LoggerFactory.getLogger(InitiatorTest.class);

    @Deployment
    public void testInitiator() {
        try {
            identityService.setAuthenticatedUserId("bono");
            runtimeService.startProcessInstanceByKey("InitiatorProcess");
        } finally {
            identityService.setAuthenticatedUserId(null);
        }

        assertEquals(1, taskService.createTaskQuery().taskAssignee("bono").count());
    }

    // See ACT-1372
    @Deployment
    public void testInitiatorWithWhiteSpaceInExpression() {
        try {
            identityService.setAuthenticatedUserId("bono");
            runtimeService.startProcessInstanceByKey("InitiatorProcess");
        } finally {
            identityService.setAuthenticatedUserId(null);
        }

        assertEquals(1, taskService.createTaskQuery().taskAssignee("bono").count());
    }

    @Deployment
    public void testInitiatorWithWhiteSpaceInInitiatorSet() {
        try {
            identityService.setAuthenticatedUserId("bono");
            runtimeService.startProcessInstanceByKey("InitiatorProcess");
            fail("should not reach here");
        } catch (FlowableException e) {
            assertThat(e).hasMessageContaining("Unknown property used in expression");
            assertThat(e).hasCauseInstanceOf(PropertyNotFoundException.class);
            log.error("Process start fail", e);
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
    }
}
