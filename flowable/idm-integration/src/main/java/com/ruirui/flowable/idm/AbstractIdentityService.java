package com.ruirui.flowable.idm;

import org.flowable.idm.api.*;

import java.util.List;

/**
 * 身份信息集成基础类，此类禁用掉了用户、组等的维护方法，这些方法在集成时是不应该被调用的（用户、组等的信息应该是在业务系统维护的）。开放了用户、组相关查询，供子类实现。
 *
 * @see SimpleIdentityService
 */
public abstract class AbstractIdentityService implements IdmIdentityService {

    @Override
    public User newUser(String userId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void saveUser(User user) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void updateUserPassword(User user) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public Group newGroup(String groupId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void saveGroup(Group group) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void deleteGroup(String groupId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void createMembership(String userId, String groupId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void deleteMembership(String userId, String groupId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        thisMethodShouldNotBeInvoked();
        return false;
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public Picture getUserPicture(String userId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public Token newToken(String id) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void saveToken(Token token) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void deleteToken(String tokenId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public TokenQuery createTokenQuery() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public NativeTokenQuery createNativeTokenQuery() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public String getUserInfo(String userId, String key) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public List<String> getUserInfoKeys(String userId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void deleteUserInfo(String userId, String key) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public Privilege createPrivilege(String privilegeName) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void addUserPrivilegeMapping(String privilegeId, String userId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void deleteUserPrivilegeMapping(String privilegeId, String userId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void addGroupPrivilegeMapping(String privilegeId, String groupId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public void deleteGroupPrivilegeMapping(String privilegeId, String groupId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public List<PrivilegeMapping> getPrivilegeMappingsByPrivilegeId(String privilegeId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public void deletePrivilege(String privilegeId) {
        thisMethodShouldNotBeInvoked();
    }

    @Override
    public List<User> getUsersWithPrivilege(String privilegeId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public List<Group> getGroupsWithPrivilege(String privilegeId) {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    @Override
    public PrivilegeQuery createPrivilegeQuery() {
        thisMethodShouldNotBeInvoked();
        return null;
    }

    protected void thisMethodShouldNotBeInvoked() {
        throw new UnsupportedOperationException("身份信息集成时此方法不应被调用");
    }
}
