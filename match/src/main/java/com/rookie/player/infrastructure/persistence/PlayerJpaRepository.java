package com.rookie.player.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerId;
@Repository
public interface PlayerJpaRepository  extends CrudRepository<Player, PlayerId>{
}
