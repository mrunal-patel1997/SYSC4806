package Spring;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;


/////////////////////////////////////SHOULD NOT BE IMPLEMENTS////////////////
public interface AddressBookRepository extends CrudRepository <AddressBook, Integer>{

    AddressBook findById (int id);
}
