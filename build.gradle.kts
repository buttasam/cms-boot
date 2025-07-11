plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.buttasam.demo"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(24)
	}
}

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.hibernate.validator:hibernate-validator")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	testImplementation("org.springframework.security:spring-security-test")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("com.h2database:h2")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.webjars:webjars-locator-core")
	compileOnly("org.webjars:bootstrap:3.3.7-1")


	// webjars dependencies
	implementation("org.webjars:bootstrap:3.3.7-1")
	implementation("org.webjars:font-awesome:4.7.0")
	implementation("org.webjars:nprogress:0.1.2")
	implementation("org.webjars:animate.css:3.5.2")
	implementation("org.webjars.bower:iCheck:1.0.2")
	implementation("org.webjars.bower:bootstrap-progressbar:0.9.0")
	implementation("org.webjars.npm:github-com-manifestinteractive-jqvmap:1.5.1")
	implementation("org.webjars.bower:bootstrap-daterangepicker:2.1.25")
	implementation("org.webjars:fastclick:1.0.6")
	implementation("org.webjars.bower:chart.js:2.5.0")
	implementation("org.webjars.bower:gauge.js:1.3.2")
	implementation("org.webjars.bower:flot:0.8.3")
	implementation("org.webjars.bower:datejs:1.0.0-rc3")
	implementation("org.webjars.bower:moment:2.18.1")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
