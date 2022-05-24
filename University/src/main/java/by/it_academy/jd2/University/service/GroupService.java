package by.it_academy.jd2.University.service;

import by.it_academy.jd2.University.dao.GroupDao;
import by.it_academy.jd2.University.dto.GroupNoId;
import by.it_academy.jd2.University.entity.Group;

import java.util.List;

public class GroupService {

    private static final GroupService instance = new GroupService();

    private final GroupDao dao;

    public GroupService() {
        this.dao = GroupDao.getInstance();
    }

    public List<Group> readAll() {

        return this.dao.readAll();
    }

    public String create(GroupNoId group){

        return this.dao.create(group);
    }

    public void delete(Long id){

        this.dao.delete(id);

    }

    public void update(GroupNoId group, Long id)
    {
        this.dao.update(group, id);
    }

    public static GroupService getInstance() {
        return instance;
    }

}
