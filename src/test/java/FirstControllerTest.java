import com.example.demo.Controller.FirstController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;


@SpringBootTest(classes = FirstController.class)
@RestController
public class FirstControllerTest {
    final ObjectMapper objectMapper =  new ObjectMapper();
    @BeforeAll
    public static void beforeAll() {

    }

    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a sample Java object
        Person person = new Person("John Doe", 30);

        // Serialize the object to JSON
        String json = objectMapper.writeValueAsString(person);
        System.out.println("JSON: " + json);

        // Deserialize JSON back to a Java object
        // todo : it is neceesry to have defualt constructor in any situastion for
        // deserializing. if not ou will het exception
        Person parsedPerson = objectMapper.readValue(json, Person.class);

        System.out.println("Parsed Person: " + parsedPerson);
    }

    static class Person {
        String name;
        int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        // Constructor, getters, and setters
    }


}
