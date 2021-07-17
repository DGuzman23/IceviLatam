package com.uca.controller;

import com.uca.model.*;
import com.uca.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    PublicationService publicationService;

    @Autowired
    DelegatesService delegatesService;

    @Autowired
    CountryService countryService;

    @Autowired
    RegionService regionService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/admin/principal")
    public String getAdminHome() {
        return "admin/principal";
    }

    @GetMapping("/admin/registrar")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.addObject("user", user);
        mav.setViewName("admin/registrar");
        return mav;
    }

    @PostMapping("/admin/registrar")
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("successMessage", "Por favor, corregir los campos con errores");
            modelMap.addAttribute("bindingResult", bindingResult);
        }else if (userService.isUserAlreadyPresent(user)) {
            mav.addObject("successMessage", "Usuario ya existe");
        }else {
            userService.save(user);
            mav.addObject("successMessage", "Usuario registrado correctamente");
        }
        mav.addObject("user", new User());
        mav.setViewName("admin/registrar");
        return mav;
    }

    @GetMapping("/admin/publicaciones")
    public ModelAndView publications() {
        ModelAndView mav = new ModelAndView();
        Publication publication = new Publication();
        mav.addObject("publication", publication);
        mav.setViewName("admin/publicaciones");
        return mav;
    }

    @PostMapping("/admin/publicaciones")
    public ModelAndView createPublication(@Valid Publication publication, BindingResult bindingResult,
                                          ModelMap modelMap) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("successMessage", "Por favor, corregir los campos con errores");
            modelMap.addAttribute("bindingResult", bindingResult);
        }else {
            publicationService.save(publication);
            mav.addObject("successMessage", "Publicación creada correctamente");
        }
        mav.addObject("publication", new Publication());
        mav.setViewName("admin/publicaciones");
        return mav;
    }

    @GetMapping("/admin/listarpublicaciones")
    public ModelAndView showPublications() {
        ModelAndView mav = new ModelAndView();
        ArrayList<Publication> publications = publicationService.getAllPublications();
        mav.addObject("publications", publications);
        mav.setViewName("admin/listarpublicaciones");
        return mav;
    }

    @RequestMapping(value = "/admin/editarpublicacion/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editarPublication(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView();
        if (publicationService.getPublicationById(id) != null) {
            Publication publication = publicationService.getPublicationById(id);
            mav.addObject("publication", publication);
        }else {
            mav.addObject("message", "No existe una publicación con ese id");
        }
        mav.setViewName("admin/editarpublicacion");
        return mav;
    }

    @PostMapping("/admin/actualizarpublicacion/{id}")
    public ModelAndView actualizarPublication(@PathVariable("id") int id, @Valid Publication publication,
                                              BindingResult bindingResult, ModelMap modelMap){
        ModelAndView mav = new ModelAndView();
        publication.setId(id);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("successMessage", "Por favor corregir los campos con errores");
            modelMap.addAttribute("bindingResult", bindingResult);
        }else {
            publicationService.save(publication);
            mav.addObject("successMessage", "Publicació actualizada correctamente");
        }
        mav.setViewName("admin/editarpublicacion");
        return mav;
    }

    @GetMapping(value = "/admin/borrarpublicacion/{id}")
    public ModelAndView deletePublication(@PathVariable("id") int id, @Valid Publication publication) {
        ModelAndView mav = new ModelAndView();
        publication.setId(id);
        publicationService.delete(publication);
        ArrayList<Publication> publications = publicationService.getAllPublications();
        mav.addObject("publications", publications);
        mav.setViewName("admin/listarpublicaciones");
        return mav;
    }

    @GetMapping("/admin/paises")
    public ModelAndView showCountries() {
        ModelAndView mav = new ModelAndView();
        ArrayList<Country> countries = countryService.getAllCountry();
        mav.addObject("countries", countries);
        mav.setViewName("admin/paises");
        return mav;
    }

    @GetMapping("/admin/subregiones")
    public ModelAndView showSubRegions() {
        ModelAndView mav = new ModelAndView();
        ArrayList<Region> regions = regionService.getAllRegion();
        mav.addObject("regions", regions);
        mav.setViewName("admin/subregiones");
        return mav;
    }

    @GetMapping("/admin/paises/{cId}/delegadosp")
    public ModelAndView delegatesPerCountry(@PathVariable("cId") int cId) {
        ModelAndView mav = new ModelAndView();
        Country country = countryService.getCountryById(cId);
        ArrayList<Delegates> delegates = delegatesService.findByCountry(country);
        mav.addObject("delegates", delegates);
        mav.addObject("cId", cId);
        mav.setViewName("admin/delegadosp");
        return mav;
    }

    @GetMapping("/admin/subregiones/{subId}/delegadosr")
    public ModelAndView delegatesPerSubRegion(@PathVariable("subId") int subId) {
        ModelAndView mav = new ModelAndView();
        Region region = regionService.getRegionById(subId);
        ArrayList<Delegates> delegates = delegatesService.findByRegion(region);
        mav.addObject("delegates", delegates);
        mav.addObject("subId", subId);
        mav.setViewName("admin/delegadosr");
        return mav;
    }

    @RequestMapping(value = "/admin/editardelegadop/{cId}/{dId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editDelegatePerCountry(@PathVariable ("cId") int cId, @PathVariable ("dId") int dId) {
        ModelAndView mav = new ModelAndView();
        if (delegatesService.getDelegateById(dId) != null) {
            Delegates delegate = delegatesService.getDelegateById(dId);
            mav.addObject("delegate", delegate);
            mav.addObject("cId", cId);
        }else {
            mav.addObject("successMessage", "No existe un delegado con ese id");
        }
        mav.setViewName("admin/editardelegadop");
        return mav;
    }

    @RequestMapping(value = "/admin/editardelegados/{sId}/{dId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editDelegatePerSubregion(@PathVariable ("sId") int sId, @PathVariable ("dId") int dId) {
        ModelAndView mav = new ModelAndView();
        if (delegatesService.getDelegateById(dId) != null) {
            Delegates delegate = delegatesService.getDelegateById(dId);
            mav.addObject("delegate", delegate);
            mav.addObject("sId", sId);
        }else {
            mav.addObject("successMessage", "No existe un delegado con ese id");
        }
        mav.setViewName("admin/editardelegados");
        return mav;
    }

    @PostMapping("/admin/actualizardelegado/{id}/{dId}")
    public ModelAndView updateDelegate(@PathVariable("id") int id, @PathVariable ("dId") int dId,
                                       @Valid Delegates delegate, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView mav = new ModelAndView();
        delegate.setId(dId);
        System.out.println(delegate.isArea());
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("successMessage", "Por favor corregir los campos");
            modelMap.addAttribute("bindingResult", bindingResult);
        }else {
            if (delegate.isArea()) {
                delegate.setCountry(countryService.getCountryById(id));
            }else {
                delegate.setRegion(regionService.getRegionById(id));
            }
            delegatesService.save(delegate);
            mav.addObject("successMessage", "Delegado actualizado correctamente");
        }
        mav.setViewName("admin/principal");
        return mav;
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDenied(Principal user){
        ModelAndView mav = new ModelAndView();
        if (user != null) {
            mav.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            mav.addObject("msg",
                    "You do not have permission to access this page!");
        }
        mav.setViewName("admin/error");
        return mav;
    }

}
