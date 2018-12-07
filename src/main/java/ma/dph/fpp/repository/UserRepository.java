/**
 * 
 */
package ma.dph.fpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.User;


/**
 * @author vsubramaniyan
 *
 */

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
}
