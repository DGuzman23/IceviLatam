package com.uca.controller;

import com.uca.model.Country;
import com.uca.model.Delegates;
import com.uca.model.Publication;
import com.uca.model.Region;
import com.uca.service.CountryService;
import com.uca.service.DelegatesService;
import com.uca.service.PublicationService;
import com.uca.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    CountryService countryService;

    @Autowired
    RegionService regionService;

    @Autowired
    DelegatesService delegatesService;

    @Autowired
    PublicationService publicationService;

    @RequestMapping(value = {"/", "/quienessomos"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getHeader() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("quienessomos");
        return mav;
    }

    @RequestMapping(value = {"/antecedentes"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getAntecedentes(Model model) { return "antecedentes";}

    @RequestMapping(value = {"/legalizacion"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getLegalizacion(Model model) { return "legalizacion";}

    @RequestMapping(value = {"/estructuraautoridades"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getEstructuraAutoridades(Model model) { return "estructuraautoridades";}

    @RequestMapping(value = {"/objetivos"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getObjetivos(Model model) { return "objetivos";}

    @RequestMapping(value = "/nuestrotrabajo", method = {RequestMethod.GET, RequestMethod.POST})
    public String getNuestroTrabajo(Model model) {
        return "nuestrotrabajo";
    }

    @RequestMapping(value = "/monitoreo", method = {RequestMethod.GET, RequestMethod.POST})
    public String getMonitoreo(Model model) {
        return "monitoreo";
    }

    @RequestMapping(value = "/delegadossubregionales", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getDelegadosSubregionales(Model model) {
        ModelAndView mav = new ModelAndView();
        ArrayList<Region> regions = regionService.getAllRegion();
        mav.addObject("regions", regions);
        mav.setViewName("delegadossubregionales");
        return mav;
    }

    @RequestMapping(value = "/delegadosnacionales", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getDelegadosNacionales(Model model) {
        ModelAndView mav = new ModelAndView();
        ArrayList<Country> countries = countryService.getAllCountry();
        mav.addObject("countries", countries);
        mav.setViewName("delegadosnacionales");
        return mav;
    }

    @RequestMapping(value = "/delegadosnacionales/{cId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getDelegadosNacionales(@PathVariable("cId") int id, Model model) {
        ModelAndView mav = new ModelAndView();
        Country country = countryService.getCountryById(id);
        ArrayList<Delegates> delegates = delegatesService.findByCountry(country);
        ArrayList<Delegates> delegatesT = new ArrayList<>(), delegatesS = new ArrayList<>();
        for (Delegates d : delegates) {
            if (d.getCharge().equals("Titulares")) {
                delegatesT.add(d);
            }else {
                delegatesS.add(d);
            }
        }
        mav.addObject("country", country);
        mav.addObject("delegates", delegates);
        mav.addObject("delegatesT", delegatesT);
        mav.addObject("delegatesS", delegatesS);
        mav.setViewName("mostrardelegadon");
        return mav;
    }

    @RequestMapping(value = "/delegadossubregionales/{sId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getDeleagadosRegionales(@PathVariable("sId") int id, Model model) {
        ModelAndView mav = new ModelAndView();
        Region region = regionService.getRegionById(id);
        ArrayList<Delegates> delegates = delegatesService.findByRegion(region);
        ArrayList<Delegates> delegatesT = new ArrayList<>();
        ArrayList<Delegates> delegatesS = new ArrayList<>();
        for (Delegates d: delegates) {
            if (d.getCharge().equals("Titulares")) {
                delegatesT.add(d);
            }else {
                delegatesS.add(d);
            }
        }
        mav.addObject("delegates", delegates);
        mav.addObject("region", region);
        mav.addObject("delegatesT", delegatesT);
        mav.addObject("delegatesS", delegatesS);
        mav.setViewName("mostrardelegados");
        return mav;
    }

    @RequestMapping(value = "/aliados", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAliados(Model model){
        return "aliados";
    }

    @RequestMapping(value = "/publicaciones", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getPublicaciones(Model model){
        ModelAndView mav = new ModelAndView();
        ArrayList<Publication> publications = publicationService.getAllPublications();
        mav.addObject("publications", publications);
        mav.setViewName("publicaciones");
        return mav;
    }

    @RequestMapping(value = "/eventos", method = {RequestMethod.GET, RequestMethod.POST})
    public String getEventos(Model model){
        return "eventos";
    }

    @RequestMapping(value = "/webinars", method = {RequestMethod.GET, RequestMethod.POST})
    public String getWebinars(Model model){
        return "webinars";
    }

    @RequestMapping(value = "/recursos", method = {RequestMethod.GET, RequestMethod.POST})
    public String getRecursos(Model model){
        return "recursos";
    }

    @RequestMapping(value = "/afiliate", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAfiliate(Model model){
        return "afiliate";
    }
}
