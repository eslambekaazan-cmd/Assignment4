import controller.ActivityController;
import db.DatabaseConnection;
import repository.interfaces.ActivityRepository;
import repository.interfaces.RoutineRepository;
import repository.interfaces.RoutineTypeRepository;
import repository.jdbc.ActivityRepositoryJdbc;
import repository.jdbc.RoutineRepositoryJdbc;
import repository.jdbc.RoutineTypeRepositoryJdbc;
import service.impl.ActivityServiceImpl;
import service.interfaces.ActivityService;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection db = new DatabaseConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres"
        );

        RoutineTypeRepository routineTypeRepo = new RoutineTypeRepositoryJdbc(db);
        RoutineRepository routineRepo = new RoutineRepositoryJdbc(db, routineTypeRepo);
        ActivityRepository activityRepo = new ActivityRepositoryJdbc(db, routineRepo);

        ActivityService activityService = new ActivityServiceImpl(activityRepo);

        ActivityController controller = new ActivityController(activityService);
        
        controller.runCli();
    }
}
