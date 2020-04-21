package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

  private static List<Spittle> allSpittles = createSpittleList(20);

  @Override
  public List<Spittle> findSpittles(long max, int count) {
    return allSpittles.subList(0, count);
  }

  @Override
  public Spittle findOne(long spittleId) {
    return allSpittles.stream().filter(spittle -> spittle.getId() == spittleId).findFirst().orElse(null);
  }

  private static List<Spittle> createSpittleList(int amount) {
    List<Spittle> spittles = new ArrayList<>();
    for (int i = 0; i < amount; i ++){
      Long id = Long.valueOf(String.valueOf(i));
      spittles.add(new Spittle(id, "Spittle " + i, new Date()));
    }
    return spittles;
  }
}
