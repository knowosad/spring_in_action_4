package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "1000000";

  private SpittleRepository spittleRepository;

  @Autowired
  public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Spittle> spittles(
//      Model model,  //jak niżej - nie potrzebuję jawnie przekazywać modelu
      @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
      @RequestParam(value = "count", defaultValue = "20") int count) {
//    model.addAttribute(spittleRepository.findSpittles(max, count)); //nazwa klucza  na podstawie typu obiektu, u nas spittleList
    return spittleRepository.findSpittles(max, count);
//    return "spittles";  //nie zwracam nazwy widoku, bo klucz modelu ustalany jest na podstawie ścieżki "/spittles", gdzie slash jest usuwany
  }

  @RequestMapping(value = "/show", method = RequestMethod.GET)
  public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
  }

  @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
  public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
  }
}
