package com.in28minutes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.model.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	List<User> findByName(String name);

	Long countByName(String name);

	Long deleteByName(String name);

	List<User> removeByName(String name);

	List<User> findByTodosTitle(String title);

	User findFirstByName(String name);

	User findTopByName(String name);

	// Keywords - Top or First
	List<User> findTop3ByName(String name);

	List<User> findFirst3ByName(String name);

	@Query("select u from User u where u.name = ?1")
	List<User> findUsersByNameUsingQuery(String name);

	@Query("select u from User u where u.name = :name")
	List<User> findUsersByNameUsingNamedParameters(@Param("name") String name);
	
	//Named Query
	List<User> findUsersWithNameUsingNamedQuery(String name);

	//Native Query
	@Query(value = "SELECT * FROM USERS WHERE u.name = ?1", nativeQuery = true)
	List<User> findUsersByNameNativeQuery(String name);
	
}
