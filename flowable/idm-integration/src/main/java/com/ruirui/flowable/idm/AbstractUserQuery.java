package com.ruirui.flowable.idm;

import org.flowable.engine.common.api.query.QueryProperty;
import org.flowable.idm.api.User;
import org.flowable.idm.api.UserQuery;

import java.util.List;

/**
 * 身份信息集成时，禁用掉维护方法，开放查询方法供子类实现。
 */
public abstract class AbstractUserQuery implements UserQuery {

    @Override
    public UserQuery userIdIgnoreCase(String id) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userFirstName(String firstName) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userFirstNameLike(String firstNameLike) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userFirstNameLikeIgnoreCase(String firstNameLikeIgnoreCase) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userLastName(String lastName) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userLastNameLike(String lastNameLike) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userLastNameLikeIgnoreCase(String lastNameLikeIgnoreCase) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userFullNameLike(String fullNameLike) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userFullNameLikeIgnoreCase(String fullNameLikeIgnoreCase) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userEmail(String email) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery userEmailLike(String emailLike) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery memberOfGroup(String groupId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery memberOfGroups(List<String> groupIds) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery orderByUserId() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery orderByUserFirstName() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery orderByUserLastName() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery orderByUserEmail() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery asc() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery desc() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery orderBy(QueryProperty property) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public UserQuery orderBy(QueryProperty property, NullHandlingOnOrder nullHandlingOnOrder) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public long count() {
        thisMethodShouldNotBeInvoked();
        return 0;
    }

    @Override
    public List<User> listPage(int firstResult, int maxResults) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    protected void thisMethodShouldNotBeInvoked() {
        throw new UnsupportedOperationException("身份信息集成时此方法不应被调用");
    }
}
