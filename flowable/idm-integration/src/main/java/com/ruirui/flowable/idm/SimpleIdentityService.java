package com.ruirui.flowable.idm;

import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.api.UserQuery;

/**
 * 实现用户和组的查询，查询类的创建委托给{@link UserQueryFactory}和{@link GroupQueryFactory}。
 */
public class SimpleIdentityService extends AbstractIdentityService {

    private UserQueryFactory userQueryFactory;

    private GroupQueryFactory groupQueryFactory;

    @Override
    public UserQuery createUserQuery() {
        return userQueryFactory.createUserQuery();
    }

    @Override
    public GroupQuery createGroupQuery() {
        return groupQueryFactory.createGroupQuery();
    }


    public void setUserQueryFactory(UserQueryFactory userQueryFactory) {
        this.userQueryFactory = userQueryFactory;
    }

    public void setGroupQueryFactory(GroupQueryFactory groupQueryFactory) {
        this.groupQueryFactory = groupQueryFactory;
    }
}
