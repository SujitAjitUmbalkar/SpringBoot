

import org.springframework.stereotype.Repository;

// @Repository marks this class as a Data Access Object (DAO).
// It connects to databases.
// SPECIAL FEATURE: It automatically catches database specific exceptions 
// and translates them into Spring's unchecked DataAccessException.
@Repository
public class DataRepository {

    public void saveData() {
        System.out.println("Saving data to database via Repository...");
    }
}
