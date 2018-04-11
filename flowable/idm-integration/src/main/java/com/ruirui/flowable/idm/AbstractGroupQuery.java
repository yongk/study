package com.ruirui.flowable.idm;

import org.flowable.engine.common.api.query.QueryProperty;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;

import java.util.List;

/**
 * 身份信息集成时，禁用掉维护方法，开放查询方法供子类实现。
 */
public abstract class AbstractGroupQuery implements GroupQuery {

    @Override
    public GroupQuery groupName(String groupName) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery groupNameLike(String groupNameLike) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery groupNameLikeIgnoreCase(String groupNameLikeIgnoreCase) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery orderByGroupId() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery orderByGroupName() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery orderByGroupType() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery asc() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery desc() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery orderBy(QueryProperty property) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public GroupQuery orderBy(QueryProperty property, NullHandlingOnOrder nullHandlingOnOrder) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public long count() {
        thisMethodShouldNotBeInvoked();
        return 0;
    }

    @Override
    public List<Group> listPage(int firstResult, int maxResults) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    protected void thisMethodShouldNotBeInvoked() {
        throw new UnsupportedOperationException("身份信息集成时此方法不应被调用");
    }
}
