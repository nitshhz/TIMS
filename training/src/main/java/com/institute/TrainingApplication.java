package com.institute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	CommandLineRunner cleanupOldTables(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection();
				 Statement stmt = conn.createStatement()) {
				// Drop the old incorrectly mapped ghost tables generated before the schema was perfected
				stmt.execute("DROP TABLE IF EXISTS fee");
				stmt.execute("DROP TABLE IF EXISTS student");
				stmt.execute("DROP TABLE IF EXISTS trainer");
				stmt.execute("DROP TABLE IF EXISTS course");
			} catch (Exception e) {
				System.out.println("Cleanup script skipped: " + e.getMessage());
			}
		};
	}
}
