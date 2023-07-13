package com.userService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.Entity.User;
import com.userService.repository.userRepository;

@Service
public class userServiceImpl implements userService {

	@Autowired private userRepository userRepo;

//	List<User> userList=List.of(
//			new User(11, "Amulya", "204432890"),
//			new User(12, "Avar", "240941282"),
//			new User(14, "Tarun", "234098342")
//	);

//	@Override
//	public User getUser(Integer id) {
//		return this.userList.stream().filter( u-> u.getUId().equals(id)).findAny().orElse(null);
//	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList=userRepo.findAll();
		return usersList;
	}

	@Override
	public User getUser(Integer id) {
		Optional<User> found=userRepo.findById(id);
		if(found==null) {
			System.out.println("the person with this id doesn't exist");
			return null;
		}else {
			return found.get();
		}
	}

	public User addUser(User u) {
		User saved=userRepo.save(u);
		return saved;
	}

	@Override
	public User updateUser(User u) {
		Optional<User> found=userRepo.findById(u.getUId());
		if(found.isPresent()) {
			User foundUser=found.get();
			BeanUtils.copyProperties(u, foundUser);
			userRepo.save(foundUser);
		}
		return null;
	}

	public String deleteUser(Integer id) {
		Optional<User> found=userRepo.findById(id);
		if(found.isPresent()) {
			userRepo.deleteById(id);
			System.out.println("the user is deleted");
			return "yea, the user is deleted.";
		}
		else {
			System.out.println("the user with that id doesn't exist");
			return "the user with that id doesn't exist.";
		}
	}

}
