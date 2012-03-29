package pl.greenwind.reallifequestlog.dao;

import java.io.Serializable;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.greenwind.reallifequestlog.model.Quest;

/**
 *
 * @author piotr.janik
 */
@Repository
@Transactional
public class DAO {

    private static final Class<Quest> clazz = Quest.class;
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria getCriteria() {
        return getSession().createCriteria(clazz);
    }

    public Quest getById(Serializable id) {
        return (Quest) getSession().get(clazz, id);
    }

    public Quest merge(Quest quest) {
        return (Quest) getSession().merge(quest);
    }

    public void delete(Quest quest) {
        getSession().delete(quest);
    }

    public Serializable save(Quest quest) {
        return getSession().save(quest);
    }

    public Collection<Quest> getAll() {
        return getCriteria().list();
    }

    public Collection<Quest> getByParentQuestId(Serializable id) {
        Criteria crit = getCriteria();
        crit.createAlias("parent", "parent", Criteria.LEFT_JOIN);

        if (id == null) {
            crit.add(Restrictions.isNull("parent.id"));
        } else {
            crit.add(Restrictions.eq("parent.id", id));
        }

        return crit.list();
    }
}
