package limjustin.playlist.domain.user;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserRepository {

    @PersistenceContext  // EntityManager 주입
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findByIdNonOptional(Long id) {
        return em.find(User.class, id);
    }

    public Optional<User> findById(Long id) {
        return Optional.of(em.find(User.class, id));  // 로그인 성공 이후에 사용하는 메서드, 확실하게 값이 있으므로 .of 사용하기
    }

    public Optional<User> findByNameAndPassword(String name, String password) {
        return em.createQuery("SELECT u from User u WHERE u.name = :name AND u.password = :password", User.class)
                .setParameter("name", name)
                .setParameter("password", password)
                .getResultList().stream().findAny();
    }  // Optional 반환의 이유 : 찾는 값이 없으면 null 반환 필요
}
