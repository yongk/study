package com.ruirui.flowable.idm.stub;

import com.ruirui.flowable.idm.UserQueryFactory;
import org.flowable.idm.api.UserQuery;

public class StubUserQueryFactory implements UserQueryFactory {
    @Override
    public UserQuery createUserQuery() {
        return new StubUserQuery();
    }
}
