package com.ruirui.flowable.idm;

import org.flowable.idm.engine.IdmEngineConfiguration;

/**
 * 不使用关系型数据库的IdmEngineConfiguration实现，参考{@link org.flowable.ldap.LdapIdmEngineConfiguration LdapIdmEngineConfiguration}实现。
 */
public class SimpleIdmEngineConfiguration extends IdmEngineConfiguration {

    public SimpleIdmEngineConfiguration() {
        setUsingRelationalDatabase(false);
    }

    @Override
    public void initDataManagers() {
        // No need to initialize data managers
    }
}
