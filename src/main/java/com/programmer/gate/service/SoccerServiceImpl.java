package com.programmer.gate.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.programmer.gate.model.Player;
import com.programmer.gate.model.Team;
import com.programmer.gate.model.User;
import com.programmer.gate.repository.PlayerRepository;
import com.programmer.gate.repository.TeamRepository;
import com.programmer.gate.repository.UserRepository;

@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private UserRepository userRepository;

	public List<String> getAllTeamPlayers(long teamId) {
		List<String> result = new ArrayList<String>();
		List<Player> players = playerRepository.findByTeamId(teamId);
		for (Player player : players) {
			result.add(player.getName());
		}

		return result;
	}

	public void addBarcelonaPlayer(String name, String position, int number) {
		
		Team barcelona = teamRepository.findOne(1l);
		
		Player newPlayer = new Player();
		newPlayer.setName(name);
		newPlayer.setPosition(position);
		newPlayer.setNum(number);
		newPlayer.setTeam(barcelona);
		playerRepository.save(newPlayer);
	}

	public void addUser(String name, int age) {

		User newUser = new User();
		newUser.setName(name);
		newUser.setAge(age);
		userRepository.save(newUser);
	}

}
