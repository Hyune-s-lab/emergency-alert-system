plugins {

}

dependencies {
    // webflux swagger
    implementation("org.springdoc:springdoc-openapi-webflux-core:1.6.12")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.12")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")

    // testcontainers
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.testcontainers:junit-jupiter:1.17.4")
    testImplementation("org.testcontainers:mysql:1.17.4")
}
