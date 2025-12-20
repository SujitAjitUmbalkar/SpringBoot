
/*
   Program: Bean ID demonstration in Spring
   Purpose: To understand how Spring assigns and uses Bean IDs
   Note   : This program is NOT meant to be executed
*/

// =======================
// 1) Default Bean ID
// =======================

import org.springframework.stereotype.Component;

@Component
class StudentService {

    // Bean ID = "studentService"
    // Rule: Class name converted to camelCase
    public void show() {
        // logic not required
    }
}

// =======================
// 2) Custom Bean ID
// =======================

import org.springframework.stereotype.Service;

@Service("customService")
class TeacherService {

    // Bean ID = "customService"
    // Rule: ID provided explicitly
}

// =======================
// 3) Bean ID using @Bean
// =======================

class Student {
    // Simple POJO class
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {

    @Bean
    public Student studentBean() {

        // Bean ID = "studentBean"
        // Rule: Method name becomes Bean ID
        return new Student();
    }
}

// =======================
// 4) Fetching Beans (Conceptual)
// =======================

/*
ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

// Fetching using Bean ID
StudentService s1 = context.getBean("studentService", StudentService.class);
TeacherService s2 = context.getBean("customService", TeacherService.class);
Student s3 = context.getBean("studentBean", Student.class);
*/

// =======================
// Key Notes
// =======================

/*
1. Every Spring bean has a unique Bean ID
2. Default ID → class name in camelCase
3. Custom ID → provided in annotation
4. @Bean ID → method name
5. Bean ID is used to fetch object from IoC container
*/


/*

### 📝 **Bean ID – Short Notes (Spring)**

* **Bean ID** is a **unique name** given to a Spring bean.
* It is used by the **Spring IoC container** to **identify and fetch** a bean.
* Every bean in Spring must have **one unique ID**.

---

#### 🔹 How Bean ID is Defined

* **XML** → using `id` attribute
  `<bean id="studentBean" class="com.example.Student"/>`
* **@Component / @Service** → class name in **camelCase**
  `StudentService` → `studentService`
* **@Component("name")** → custom bean ID
* **@Bean** → method name becomes bean ID

---

#### 🔹 Why Bean ID is Important

* To **retrieve a bean** from the container
* To **resolve multiple bean conflicts**
* Used with `@Qualifier` for **specific injection**

---

#### 🎯 One-Line Definition (Exam/Interview)

> Bean ID is the unique identifier used by Spring to manage and access a bean from the IoC container.





*/