package com.sanket.ll.room_clr;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class RoomClrApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomClrApplication.class, args);
	}

	// This bean can be used to run code when the application starts up and will end
	// when the code completes
	// Unlike web applications, console applications will end when the code in this
	// method completes
	/**
	 * Creates a CommandLineRunner bean that executes custom logic when the Spring
	 * Boot application starts.
	 * 
	 * A CommandLineRunner is a functional interface that allows you to run specific
	 * code after the
	 * Spring application context has been fully initialized. This is useful for
	 * initialization tasks,
	 * data loading, or any setup logic that needs to execute at application
	 * startup.
	 * 
	 * @Bean annotation registers this method's return value as a Spring bean in the
	 *       application context,
	 *       making it available for dependency injection and managed by Spring's
	 *       lifecycle.
	 * 
	 * @return a CommandLineRunner implementation that accepts command line
	 *         arguments and executes
	 *         the defined logic (in this case, printing a count from 0 to 100)
	 */
	@Bean
	@Order(2)
	public CommandLineRunner commandLineRunner() {
		return args -> {
			for (int i = 0; i <= 100; ++i) {
				System.out.println("Counting: " + i);

				// Challenge
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.println("FizzBuzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				}
			}
		};
	}

	/**
	 * Creates an ApplicationRunner bean that executes custom logic when the Spring
	 * Boot application starts.
	 * 
	 * An ApplicationRunner is a functional interface that allows you to run
	 * specific
	 * code after the
	 * Spring application context has been fully initialized. It provides access to
	 * application arguments
	 * in a structured manner, making it easier to handle command line options and
	 * parameters.
	 * 
	 * @Bean annotation registers this method's return value as a Spring bean in the
	 *       application context,
	 *       making it available for dependency injection and managed by Spring's
	 *       lifecycle.
	 * 
	 * @return an ApplicationRunner implementation that accepts application
	 *         arguments
	 *         and executes
	 *         the defined logic (in this case, printing a count up to a specified
	 *         maximum value)
	 */
	@Bean
	@Order(1)
	public ApplicationRunner applicationRunner() {
		return args -> {
			// ApplicationRunner is similar to CommandLineRunner but provides access to
			// application arguments in a more structured way
			for (int i = 0; i <= Integer.parseInt(args.getOptionValues("max").get(0)); ++i) {
				System.out.println("Counting: " + i);
			}
		};
	}

}
