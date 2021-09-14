package com.rookie.player.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerRepository;
@Repository
public class H2PlayerRepository implements PlayerRepository{

	private final PlayerJpaRepository repo;
	
	
	public H2PlayerRepository(PlayerJpaRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public void save(Player player) {
		repo.save(player);
		
	}

}
