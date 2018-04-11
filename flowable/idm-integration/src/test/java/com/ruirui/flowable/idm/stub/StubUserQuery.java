package com.ruirui.flowable.idm.stub;

import com.ruirui.flowable.idm.AbstractUserQuery;
import org.flowable.idm.api.User;
import org.flowable.idm.api.UserQuery;

import java.util.List;

public class StubUserQuery extends AbstractUserQuery {
    @Override
    public UserQuery userId(String id) {
        return null;
    }

    @Override
    public UserQuery userIds(List<String> ids) {
        return null;
    }

    @Override
    public User singleResult() {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
