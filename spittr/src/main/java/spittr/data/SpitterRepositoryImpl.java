package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spitter;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

  private List<Spitter> spitterList = new ArrayList<>();

  @Override
  public void save(Spitter spitter) {
    spitterList.add(spitter);
  }

  @Override
  public Spitter findByUsername(String username) {
    return spitterList.stream().filter(spitter -> spitter.getUsername().equals(username)).findFirst().orElse(null);
  }
}
