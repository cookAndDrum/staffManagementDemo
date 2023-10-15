package com.teamcs;

import com.teamcs.entities.UserAccount;
import com.teamcs.entities.UserProfile;
import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.repositories.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class StaffManagementDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementDemoApplication.class, args);
	}

	// Add some admin and staff user during runtime
	@Bean
	CommandLineRunner run (
			UserAccountRepository userAccountRepository,
			UserProfileRepository userProfileRepository
	) {
		return args -> {
			if (userProfileRepository.findByProfile("ADMIN").isPresent())
				return;
			UserProfile adminProfile = new UserProfile("ADMIN", "");
			userProfileRepository.save(adminProfile);
			UserAccount adminUser = new UserAccount("chris", "admin",
					"admin@mail.com", "password", adminProfile);
			userAccountRepository.save(adminUser);

			UserProfile staffProfile = new UserProfile("STAFF", "Chef, Waiter, Cashier");
			userProfileRepository.save(staffProfile);

			IntStream.range(0, 10).forEach(i -> {
				String nameUsername = String.format("staff_%d", i + 1);
				userAccountRepository.save(new UserAccount(nameUsername, nameUsername,
						String.format("%s@mail.com", nameUsername), "password", staffProfile));
			});

			UserAccount suspendedStaff = new UserAccount("badBoy", "badBoy",
					"bad@mail.com", "password", staffProfile);
			suspendedStaff.setAccountSuspended(true);
			userAccountRepository.save(suspendedStaff);
		};
	}
}
