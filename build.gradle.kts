import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.16"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "hs.kr.equus"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2021.0.8"

dependencies {

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//config server
	implementation("org.springframework.cloud:spring-cloud-config-server")

	//actuator
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//bootstrap
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

	//bus
	implementation("org.springframework.cloud:spring-cloud-starter-bus-amqp")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
