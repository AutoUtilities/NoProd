plugins {
    `maven-publish`
    signing
    java
}

group = "io.github.vijaymano998"
version = "1.0.0"

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("My TestNG Project")
                description.set("A sample TestNG project published to Maven Central.")
                url.set("https://github.com/AutoUtilities/NoProd.git")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("vijaymano998")
                        name.set("Your Name")
                        email.set("your@email.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/AutoUtilities/NoProd.git")
                    developerConnection.set("scm:git:ssh://github.com/AutoUtilities/NoProd.git")
                    url.set("https://github.com/AutoUtilities/NoProd.git")
                }
            }
        }
    }

    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = findProperty("ossrhUsername") as String
                password = findProperty("ossrhPassword") as String
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}
