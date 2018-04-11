package com.ruirui.flowable.idm;

import org.flowable.engine.common.AbstractEngineConfiguration;
import org.flowable.engine.impl.cfg.IdmEngineConfigurator;
import org.flowable.engine.impl.util.EngineServiceUtil;

/**
 * 设置{@link org.flowable.idm.engine.IdmEngineConfiguration IdmEngineConfiguration}，配置{@link org.flowable.idm.api.IdmIdentityService IdmIdentityService}。参考{@link org.flowable.ldap.LDAPConfigurator LDAPConfigurator}实现。
 */
public class SimpleIdmEngineConfigurator extends IdmEngineConfigurator {

    private Integer priority;

    private UserQueryFactory userQueryFactory;
    private GroupQueryFactory groupQueryFactory;

    @Override
    public void beforeInit(AbstractEngineConfiguration engineConfiguration) {
        // do nothing
    }

    @Override
    public void configure(AbstractEngineConfiguration engineConfiguration) {
        this.idmEngineConfiguration = new SimpleIdmEngineConfiguration();

        super.configure(engineConfiguration);

        SimpleIdentityService identityService = new SimpleIdentityService();
        identityService.setUserQueryFactory(userQueryFactory);
        identityService.setGroupQueryFactory(groupQueryFactory);
        EngineServiceUtil.getIdmEngineConfiguration(engineConfiguration)
                .setIdmIdentityService(identityService);
    }

    @Override
    public int getPriority() {
        if (priority == null) {
            priority = super.getPriority();
        }
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setUserQueryFactory(UserQueryFactory userQueryFactory) {
        this.userQueryFactory = userQueryFactory;
    }

    public void setGroupQueryFactory(GroupQueryFactory groupQueryFactory) {
        this.groupQueryFactory = groupQueryFactory;
    }
}
