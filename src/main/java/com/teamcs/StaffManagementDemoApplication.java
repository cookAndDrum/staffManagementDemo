package com.teamcs;

import com.teamcs.entities.UserAccount;
import com.teamcs.entities.UserProfile;
import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.repositories.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class StaffManagementDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementDemoApplication.class, args);
	}

	/**
	 *
	 * @param userAccountRepository
	 * @param userProfileRepository
	 * @return
	 *
	 * Generate At least
	 * 1. One Admin user
	 * 2. 100 userAccounts of random profiles excluding admin
	 * 3. One suspended user
	 * 4. One generic owner
	 * 5. One generic manager
	 */
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

			List<UserProfile> staffProfileList = List.of(
					new UserProfile("STAFF", "Chef"),
					new UserProfile("STAFF", "Cashier"),
					new UserProfile("STAFF", "Waiter"),
					new UserProfile("OWNER", "owner"),
					new UserProfile("MANAGER", "manager")
			);

			userProfileRepository.saveAll(staffProfileList);

			IntStream.range(0, 100).forEach(i -> {
				Random random = new Random();
				UserProfile randomProfile = staffProfileList.get(random.nextInt(staffProfileList.size()));
				String nameUsername = String.format("%s_%d", randomProfile.getRole() , i + 1);
				userAccountRepository.save(new UserAccount(nameUsername, nameUsername,
						String.format("%s@mail.com", nameUsername), "password", randomProfile));
			});

			UserAccount suspendedStaff = new UserAccount("badBoy", "badBoy",
					"bad@mail.com", "password", staffProfileList.get(1));
			suspendedStaff.setAccountSuspended(true);
			userAccountRepository.save(suspendedStaff);

			UserAccount ownerUser = new UserAccount("owner", "owner",
					"owner@mail.com", "password", staffProfileList.get(3));
			userAccountRepository.save(ownerUser);
			UserAccount managerUser = new UserAccount("manager", "manager",
					"manager@mail.com", "password", staffProfileList.get(4));
			userAccountRepository.save(managerUser);
		};
	}
}
