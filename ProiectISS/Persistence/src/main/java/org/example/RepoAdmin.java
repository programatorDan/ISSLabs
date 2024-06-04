package org.example;

import org.hibernate.Session;

public class RepoAdmin {
    public Admin FindOne(String name, String pass) {
        Admin admin = null;
        try (Session session = HibernateUtils.getAdmin().openSession()) {
            admin = session.createSelectionQuery("from Admin where email=:name and password=:pass", Admin.class)
                    .setParameter("name", name).setParameter("pass", pass).getSingleResultOrNull();
        } catch (Exception e) {
            throw e;
        }
        return admin;
    }
}
