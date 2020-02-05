package Spring;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository <BuddyInfo, Integer> {


    //Optional<BuddyInfo> findById (Integer id);
    BuddyInfo findById (int id);

    //@Query ("select b from BuddyInfo where name = ?1")
    BuddyInfo findByName (String name);


}
