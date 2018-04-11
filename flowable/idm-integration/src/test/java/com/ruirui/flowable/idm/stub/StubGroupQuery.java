package com.ruirui.flowable.idm.stub;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ruirui.flowable.idm.AbstractGroupQuery;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StubGroupQuery extends AbstractGroupQuery {

    private String userId;

    private Map<String, List<Group>> userGroupMap = Maps.newHashMap();

    public StubGroupQuery() {
        try (InputStream is = StubGroupQuery.class.getResourceAsStream("user-group-map.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            Enumeration<?> enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String userId = (String) enumeration.nextElement();
                String[] groupIds = properties.getProperty(userId).split(",");

                for (String groupId : groupIds) {
                    List<Group> groupList = userGroupMap.get(userId);
                    if (groupList == null) {
                        groupList = Lists.newArrayList(new StubGroup(groupId));
                        userGroupMap.put(userId, groupList);
                    }
                    else {
                        groupList.add(new StubGroup(groupId));
                    }
                }
            }
        } catch (IOException ex) {
            // ignore
        }
    }

    @Override
    public GroupQuery groupId(String groupId) {
        return null;
    }

    @Override
    public GroupQuery groupIds(List<String> groupIds) {
        return null;
    }

    @Override
    public GroupQuery groupType(String groupType) {
        return null;
    }

    @Override
    public GroupQuery groupMember(String groupMemberUserId) {
        this.userId = groupMemberUserId;
        return this;
    }

    @Override
    public GroupQuery groupMembers(List<String> groupMemberUserIds) {
        return null;
    }

    @Override
    public Group singleResult() {
        List<Group> list = list();
        if (list.size() == 0)
            return null;
        if (list.size() == 1)
            return list.get(0);
        else
            throw new IllegalArgumentException("查询到的结果多于一条记录");
    }

    @Override
    public List<Group> list() {
        return userGroupMap.get(userId);
    }

    static class StubGroup implements Group {

        String id;

        public StubGroup(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void setId(String id) {

        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public void setName(String name) {

        }

        @Override
        public String getType() {
            return null;
        }

        @Override
        public void setType(String string) {

        }
    }
}
