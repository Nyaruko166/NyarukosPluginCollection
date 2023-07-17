package me.nyaruko166.nyarukosplugincollection.repository;

import me.nyaruko166.nyarukosplugincollection.utils.HibernateUtil;
import me.nyaruko166.nyarukosplugincollection.entity.DamageLog;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DamageLogRepository {

    private String fromTable = "FROM DamageLog";
    Transaction transaction = null;

    public List<DamageLog> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DamageLog getOne(String playerName) {
        DamageLog log = new DamageLog();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            log = session.get(DamageLog.class, playerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }

    public void add(DamageLog log) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(log);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
