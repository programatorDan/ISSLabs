package org.example;

import org.hibernate.Session;

import java.util.List;
import java.util.Objects;

public class RepoMovie {
    public void addMovie(Movie movie) {
        HibernateUtils.getMovie().inTransaction(session -> session.persist(movie));
    }

    public void updateMovie(Movie movie) {
        HibernateUtils.getMovie().inTransaction(session -> {
            if (!Objects.isNull(session.find(Movie.class, movie.getId()))) {
                session.merge(movie);
                session.flush();
            }
        });
    }

    public void deleteMovie(Long id) {
        HibernateUtils.getMovie().inTransaction(session -> {
            Movie movie = session.createQuery("from Movie where id=?1", Movie.class)
                    .setParameter(1, id).uniqueResult();
            if (movie != null) {
                session.remove(movie);
                session.flush();
            }
        });
    }

    public List<Movie> findTitle(String title) {
        try (Session session = HibernateUtils.getMovie().openSession()) {
            return session.createQuery("from Movie film where film.title=?1", Movie.class)
                    .setParameter(1, title).getResultList();
        }
    }

    public Movie findOne(Long id) {
        try (Session session = HibernateUtils.getMovie().openSession()) {
            return session.createSelectionQuery("from Movie where id=:idM", Movie.class)
                    .setParameter("idM", id)
                    .getSingleResultOrNull();
        }
    }
}
