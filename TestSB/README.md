### cau 1: 
Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế nào? Hãy giải thích rõ cần thì minh hoạ.

- Thuộc tính name trong annotation @Entity được sử dụng để xác định tên của đối tượng trong java
mà bạn muốn ánh xạ vào database 
  - VD:
```java
    @Entity(name = "User")
    public class User {
        // ...
    }
```


- Thuộc tính name trong annotation @Table được sử dụng để xác định tên bảng trong database mà đối tượng sẽ được ánh xạ vào
  - VD:
```java
    @Entity
    @Table(name = "user")
    public class User {
        // ...
    }
```


### cau 2:
Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties?

```java
    # ===============================
    # DATABASE
    # ===============================
    spring.datasource.url=jdbc:mysql://localhost:3306/db-example?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=root
    
    # ===============================
    # JPA / HIBERNATE
    # ===============================
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```


### cau 3:

Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính.
- Tham số nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính
- Tham số nào chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu
- Tham số nào buộc trường không được null?

Tra loi:
   - Có thể sử dụng thuộc tính name trong annotation @Column
   - unique = true
   - nullable = false

### cau 4:

Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung

- Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)
- Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE)
- Vậy 2 annotation này là gì

tra loi:
      Là 2 annotation @PrePersist và @PreUpdate
          - @PrePersist sử dụng để xác định một phương thức trong đối tượng Entity sẽ được thực thi trước khi đối tượng này được lưu xuống CSDL (ngay trước lệnh INSERT)
          - @PreUpdate  sử dụng để xác định một phương thức trong đối tượng Entity sẽ được thực thi trước khi đối tượng này được cập nhật trong CSDL (ngay trước lệnh UPDATE)


### cau 5:
JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?

tra loi:

- Interface JpaRepository không kế thừa từ bất kỳ interface nào. 
- JpaRepository là một interface độc lập và nằm trong thư viện Spring Data JPA.


### cau 6:

Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu trường Identity là Long, tuân thủ interface JpaRepository.

Class Post:
```java
    @Entity
    public class Post {
        @Id
        private Long id;
    }
```

Repository

```java
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {
        //
    }
```

### cau 7:
Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique dùng annotation @Column(unique=true) không?

    - Khi đã chọn một cột là Identity dùng @Id, không cần phải sử dụng annotation @Column(unique = true) để xác định rằng cột đó cũng là duy nhất. 
    - Trong JPA, các cột được đánh dấu bằng @Id đã được ngầm hiểu là duy nhất (unique) mặc định.

### cau 8:
Giả sử có 1 class Employee với các fields sau {id, emailAddress, firstName, lastName}. Hãy viết các method trong interface EmployeeRespository để :

- Tìm tất cả các Employee theo emailAddress và lastName
- Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
- Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
- Tìm tất cả các Employee theo fistName không phân biệt hoa thường

tra loi:

Class Employee:
```java
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "employee")
    public class Employee {
        @Id
        private Integer id;
        @Column(name = "email",unique = true)
        private String emailAddress;
        private String firstName;
        private String lastName;
    }
```

Interface EmployeeRepository:
```java
    @Repository
    public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

    //Tìm tất cả các Employee theo emailAddress và lastName
    List<Employee> findAllByEmailAddressAndLastName(String emailAddress, String lastName);

    //Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
    List<Employee> findDistinctByFirstNameOrLastName(String firstName, String lastName);

    //Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
    List<Employee> findAllByLastNameOrderByFirstNameAsc(String lastName);

    //Tìm tất cả các Employee theo fistName không phân biệt hoa thường
    List<Employee> findAllByFirstNameIgnoreCase(String firstName);

}
```

### cau 9:
Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ

- Sử dụng @NamedQuery:
    - VD:
    ```java
        @Entity
        @NamedQuery(
            name = "Employee.findByLastName",
            query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"
        )
        public class Employee {
            @Id
            private Integer id;
  
            @Column(name = "email",unique = true)
            private String emailAddress;
  
            private String firstName;
            private String lastName;
        }   

    ```
  
- Sử dụng @Query:
    - VD:
    ```java
        @Repository
        public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
            @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
            List<Employee> findByLastName(@Param("lastName") String lastName);
        }
    ```

### cau 10:
Hãy nêu 1 ví dụ sử dụng sorting và paging khi query đối tượng Employee ở trên:
- VD:

Interface EmployeeRepository:
```java
    @Repository
    public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
        // Tìm tất cả Employee, sắp xếp theo firstName tăng dần và thực hiện phân trang
        Page<Employee> findAllByOrderByFirstNameAsc(Pageable pageable);
    }
```


Class EmployeeService:
```java
    @Service
    public class EmployeeService {
        @Autowired
        private EmployeeRespository employeeRepository;
    
    
        public Page<Employee> findAllEmployees(int page, int size) {
            Pageable pageable = PageRequest.of(page, size);
            return employeeRepository.findAllByOrderByFirstNameAsc(pageable);
        }
    }
```


### cau 11:
Có 3 Entity Product.java và Category.java và Tag.java

- Hãy bổ sung định nghĩa quan hệ One to Many giữa bảng Category (One) – Product (Many). Chú ý khi một Category xoá, thì không được phép xoá Product, mà chỉ set thuộc tính Category của Product là null.
- Hãy bổ sung định nghĩa quan hệ Many to Many giữa bảng Tag(Many) – Product(Many).

Product.java
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="product")
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;
    }
```
Category.java
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="category")
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        
        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Product> products = new ArrayList<>();
    }
```

Tag.java
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="tag")
    public class Tag {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        
        @ManyToMany
        @JoinTable(
                name = "product_tag",
                joinColumns = @JoinColumn(name = "tag_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id")
        )
        private List<Product> products = new ArrayList<>();
    }
```


### cau 12:
Cho class User.java như sau:
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="user")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
    }
```


Viết câu lệnh query để tìm kiếm UserDto bao gồm các thuộc tính (id, name, email) theo cách sau (mỗi cách 1 câu lệnh truy vấn)

- Method query
- JPQL Query
- Native Query
- Projection

trả lời:

Method query:

```java
    @Repository
    public interface UserRepository extends JpaRepository<User, Integer> {
        List<UserDto> findByName(String name);
    }
```

JPQL Query:
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="user")
    @SqlResultSetMapping(
            name = "UserDtoMapping",
            classes = {
                    @ConstructorResult(
                            targetClass = UserDto.class,
                            columns = {
                                    @ColumnResult(name = "id", type = Long.class),
                                    @ColumnResult(name = "name", type = String.class),
                                    @ColumnResult(name = "email", type = String.class)
                            }
                    )
            }
    )
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
    }
```

Native Query
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="user")
    @NamedNativeQuery(
            name = "User.findUserDtoByNameNative",
            query = "SELECT id, name, email FROM user WHERE name = :name",
            resultClass = UserDto.class
    )
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
    }
```

Projection
```java
    public interface UserDto {
        Integer getId();
        String getName();
        String getEmail();
    }
    
    @Repository
    public interface UserRepository extends JpaRepository<User, Integer> {
        List<UserDto> findByName(String name);
    }

```

### cau 13:
Cho class Post.java như sau
```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="post")
    public class Post {
        @Id
        private String id;
        private String title;
    }
```

Viết custom generate id để tạo id ngẫu nhiên cho đối tượng post ở trên

Chú ý custom generate id ở đây là tự động tạo ID giống như @GeneratedValue, 
chúng ta không cần tự set ID thủ công cho Entity mà ID sẽ được tự động thêm vào


```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="post")
    public class Post {
        @Id
        private String id;
        private String title;
    
        //tu dong tao id ngau nhien
        //goi truoc khi luu vao CSDL
        @PrePersist
        private void generateId() {
            if (id == null) {
                String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                StringBuilder randomString = new StringBuilder();
    
                Random random = new Random();
                for (int i = 0; i < 4; i++) {
                    int index = random.nextInt(chars.length());
                    char randomChar = chars.charAt(index);
                    randomString.append(randomChar);
                }
                id = randomString.toString();
    
    
                //hoac don gian hon la su dung UUID
                // Tạo một UUID ngẫu nhiên làm ID
                //id = UUID.randomUUID().toString();
            }
        }
    }
```
