# Web Service <br/>

**1. Front-end(HTML/CSS/JavaScript, BootStrap, AngularJS)**  <br/>
**2. Back-end (Spring, Hibernate)** <br/><br/>

## BootStrap<br/> 
브라우저의 크기에 따라 페이지가 반응하는 **반응형 웹** 을 구축할 수 있는 프레임워크

* BootStrap을 사용하기 위해 jQuery와 Popper.js의 CDN버전을 넣어주어야 한다.

* BootStrap은 Mobile First이다.<br/><br/>

**Mobile First**<br/>
모바일을 우선적으로 고려. 중요도에 따라 어떤 컨텐츠를 보여줄 것인지 결정<br/>
작은 가로폭을 우선으로 디자인하고 큰 가로폭 순서로 만드는 것<br/>
min-width를 이용한다.<br/><br/>

**Desktop First**<br/>
큰 가로폭을 우선으로 디자인하고 작은 가로폭 순서로 만드는 것.<br/>
max_width를 이용한다.<br/><br/>
<br/><br/>

# eStore Application <br/>
**1. Define Domain Model(Product)**<br/><br/>
**2. CRUD Operation for Product Model**<br/><br/>
를 구현한다.
<br/><br/>

## Data Access Layer <br/>
![Data Access Layer](https://user-images.githubusercontent.com/45901815/172137033-9ec9bf4c-b795-41e6-83b3-90267d73bc1d.JPG)
<br/><br/>

Data Base 관련된 프로그램을 할 때는 spring에서 제공하는 JDBC Template를 사용해 JDBC 드라이버를 통해 데이터베이스에 접근할 수 있다.<br/>
JDBC Template 이 동작하기 위해 Data Source 정보가 필요하다. <br/>
Data Source를 가져와 JDBC Driver를 통해 Data base에 접근한다.<br/>
-> jabc class : spring jdbc, data source: commons-dbcp, jdbc driver: mysql-connector-java가 필요

* pom.xml에 라이브러리 추가<br/><br/>
  
		<!-- spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>

		<!-- commons-dbcp2 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-dbcp2</artifactId>
			<version>2.1.1</version>
		</dependency>

		<!--mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.38</version>
		</dependency>

<br/><br/>

## Web Deployment descriptor <br/>
![Web deployment descriptor](https://user-images.githubusercontent.com/45901815/172137294-00e09420-2d82-4870-b432-aee86768fbfb.JPG)
<br/><br/>
ContextLoadListner와  DispacherSerlvet가 관리하는 spring container가 존재한다.<br/>
ContextLoadListner가 관리하는 컨테이너에는 DAO, DataSource, Service와 같은 bean들을 관리한다.<br/>
DispacherSerlvet가 관리하는 컨테이너에는 주로 controller가 들어있다.<br/>
ContextLoadListner는 root-context.xml를, DispacherSerlvet는 servlet-context.xml를 읽어서 설정 작업이 이루어진다.<br/>
<br/>

lombok을 이용하면 Getter와 Setter를 손쉽게 사용할 수 있다.<br/>
* pom.xml에 lombok 라이브러리 추가<br/>
  
<!-- lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.16.18</version>
			<scope>provided</scope>
		</dependency>
    

@Getter(접근자), @Setter(설정자), @ToString(변수값을 리턴) 등의 Annotation을 사용 할 수 있다.

<br/><br/>
## CRUD 
**Create Read Update Delete**<br/>
Annotation을 활용 <br/>
* @Controller Annotation을 사용하여 class에 빈을 자동으로 컨테이너에서 관리 <br/>
	* controller -> service 호출 -> dao 사용 <br/>
* @Autowired를 사용하여 의존적 주입 dependency injection <br/>

* @RequestMapping("/") 을 사용하여 url 매핑 <br/>

* @Service 를 사용하여 빈으로 등록
	* service-context.xml에서 등록되어있는 패키지를 스캔하여 Service라되어있는 부분을 빈으로 등록
	* Service는 DAO를 이용한다.

<br/>

+ DAO에는 @Repository
+ Controller에는 @Controller
+ Service에는 @Service
<br/><br/>

+ ProductDao.java<br/> 
@Autowired가 dao-context의 dataSource타입의 데이터를 주입하여 jdbcTemplate을 생성한다.<br/>
		
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

<br/>
DB에서 받는 데이터는 redcord상태로 넘어오게 되는데 이것을 객체(object)형태로 매핑시킨다.<br/>
+ new RowMapper<Product>() 를 익명클래스로 구현
+ mapRow는 레코드 수 만큼 호출된다.
	
	return jdbcTemplate.query(sqlStatement,new RowMapper<Product>() {

		@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setCategory(rs.getString("category"));
					product.setManufacturer(rs.getString("manufacturer"));
					product.setUnitInStock(rs.getInt("unitInStock"));
					product.setDescription(rs.getString("description"));
					//product.setPrice(rs.getInt("price"));
					return product;
					
			}

		});

<br/><br/>

jstl/core를 사용해 데이터를 출력. prefix="c" 로 되어있음을 기억한다<br/>
밑 코드를 추가해 테이블로 출력. <br/>
+ w3schools.com의 BS4 Tables
+ 동적으로 Database를 읽어온다. databaseCore를 활용<br/>

		<c:forMach var="product" items="${products }"></c:forMach>
	
+ items="${products }"에서 products는 controller에 있는 key값과 일치해야한다.<br/>

<tr> : tableRow

	<div class="container-wapper">
		<div class="container">
			<h2>All Products</h2>
			<p>착한 가격으로 상품을 살펴보세요 :)</p>
			<table class="table table-striped">
				<thead>
					<tr class = "bg-success">
						<th>Name</th>
						<th>Category</th>
						<th>Price</th>
						<th>Manufacturer</th>
						<th>UnitInStock</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<td>${product.name}</td>
							<td>${product.category}</td>
							<td>${product.price}</td>
							<td>${product.manufacturer}</td>
							<td>${product.unitInStock}</td>
							<td>${product.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

home.jsp와 products.jsp의 중복된 부분을 apache tiles를 사용하여 재구성

pom.xml에 라이브러리 추가
⁠
	<!-- tiles-extras -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>3.0.8</version>
		</dependency>


servlet-context의 
	
	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
		<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<beans:property name="prefix" value="/WEB-INF/views/" />
			<beans:property name="suffix" value=".jsp" />
		</beans:bean>
	
를 통해 웹 페이지를 바꿔왔다.

대신 두가지 빈을 등록
	
	<beans:bean id="tilesViewResolver"
		class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
	</beans:bean>
	<beans:bean id="tilesConfigurer"
		class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<beans:property name="definitions">
			<beans:list>
				<beans:value>/WEB-INF/tiles-def/tiles.xml</beans:value>
			</beans:list>
		</beans:property>
	</beans:bean>

반복되는 코드를 없애기 위해 layout, menu, footer.jsp를 생성
apache tiles를 사용하기 위해 밑 태그립 사용
	
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

