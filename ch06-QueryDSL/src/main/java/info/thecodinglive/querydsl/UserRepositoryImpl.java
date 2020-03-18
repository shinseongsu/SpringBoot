package info.thecodinglive.querydsl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom{

	public UserRepositoryImpl() {
        super(UserEntity.class);
    }

    @Override
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    
	@Override
	public List findAllLike(String keyword) {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		JPQLQuery<UserEntity> query = from(qUserEntity);
		List<UserEntity> resultlist = query.where(qUserEntity.username.like(keyword))
				.fetch();
		
		return resultlist;
	}

	@Override
	public int maxAge() {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		return from(qUserEntity).select(qUserEntity.age.max()).fetchOne();
	}

	@Override
	public int minAge() {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		return from(qUserEntity).select(qUserEntity.age.min()).fetchOne();
	}
    
    

}
