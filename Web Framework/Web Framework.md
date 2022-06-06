# Web Service <br/>

**1. Front-end(HTML/CSS/JavaScript, BootStrap, AngularJS)**  <br/>
**2. Back-end (Spring, Hibernate)** <br/><br/>

## BootStrap<br/> 
디바이스 크기에 따른 반응형 웹 개발

브라우저의 크기에 따라 페이지가 반응하는 반응형 웹을 구축할 수 있는 프레임워크

BootStrap은 Mobile First이다.

BootStrap을 사용하기 위해 jQuery와 Popper.js의 CDN버전을 넣어주어야 한다.<br/><br/>

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
