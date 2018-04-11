package com.ruirui.flowable.idm.stub;

import com.ruirui.flowable.idm.GroupQueryFactory;
import org.flowable.idm.api.GroupQuery;

public class StubGroupQueryFactory implements GroupQueryFactory {
    @Override
    public GroupQuery createGroupQuery() {
        return new StubGroupQuery();
    }
}
