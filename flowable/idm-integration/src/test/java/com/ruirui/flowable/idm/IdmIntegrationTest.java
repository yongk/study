package com.ruirui.flowable.idm;

import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableTestCase;
import org.flowable.task.api.Task;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IdmIntegrationTest extends FlowableTestCase {

    @Deployment
    public void testFetchGroupsOk() {
        runtimeService.startProcessInstanceByKey("Process");

        List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();
        assertThat(tasks.size()).isEqualTo(1);
    }
}
