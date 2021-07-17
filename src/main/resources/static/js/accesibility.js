const setDefaultTheme = (element) => {
   element.addEventListener("load", () => {
      let contrastStatus = localStorage.getItem("highContrast");
      if(contrastStatus === undefined){
         console.log(contrastStatus);
         document.querySelector("body").classList.add("light");
      }else if (contrastStatus === "true"){
         document.querySelector("body").classList.add("high");
         console.log(contrastStatus);
      }else {
         document.querySelector("body").classList.add("light");
         console.log(contrastStatus);
      }
   });
}

const contrast = (element) => {
   element.addEventListener("click", () => {
      let contrastStatus = localStorage.getItem("highContrast");
      if(contrastStatus === undefined){
         document.querySelector("body").className = "high";
         localStorage.setItem("highContrast", "true");
      }else if (contrastStatus === "true"){
         document.querySelector("body").className = "light";
         localStorage.setItem("highContrast", "false");
      }else {
         document.querySelector("body").className = "high";
         localStorage.setItem("highContrast", "true");
      }
   });
}

/*const contrast = (element) => {
    element.addEventListener("click", () => {
       document.body.style.background = "#27143C";
       document.body.style.color = "white";
       document.getElementById("header-decoration").style.background = "#FFF7FE";
       document.getElementById("header").style.background = "#27143C";
       document.getElementById("navbar").style.background = "#FDE0FD";
       document.getElementById("navbar").style.color = "white";
       document.getElementById("quinessomos").style.background = "#FDE0FD";
       document.getElementById("antecedentes").style.background = "#FDE0FD";
       document.getElementById("legalizacion").style.background = "#FDE0FD";
       document.getElementById("objetivos").style.background = "#FDE0FD";
       document.getElementById("estructura").style.background = "#FDE0FD"
       document.getElementById("monitoreo").style.background = "#FDE0FD";
       document.getElementById("subregionales").style.background = "#FDE0FD";
       document.getElementById("nacionales").style.background = "#FDE0FD";
       document.getElementById("aliados").style.background = "#FDE0FD";
       document.getElementById("publicaciones").style.background = "#FDE0FD";
       document.getElementById("eventos").style.background = "#FDE0FD";
       document.getElementById("webinars").style.background = "#FDE0FD";
       document.getElementById("recursos").style.background = "#FDE0FD";
       document.getElementById("afiliar").style.background = "#FDE0FD";
       document.getElementById("afiliar-link").style.background = "#FDE0FD";
       document.getElementById("lang-es").style.background = "#FDE0FD";
       document.getElementById("lang-en").style.background = "#FDE0FD";
       document.getElementById("contrast").style.background = "#FDE0FD";
       document.getElementById("increase").style.background = "#FDE0FD";
       document.getElementById("decrease").style.background = "#FDE0FD";
       document.getElementById("menu-quienessomos").style.background = "#FDE0FD";
       document.getElementById("menu-delegados").style.background = "#FDE0FD";
       document.getElementById("menu-eventos").style.background = "#FDE0FD";
       document.getElementById("menu-afiliar").style.background = "#FDE0FD";
       document.getElementById("menu-idioma").style.background = "#FDE0FD";
       document.getElementById("menu-accesibilidad").style.background = "#FDE0FD";
       document.getElementById("quinessomos").style.color = "black";
       document.getElementById("antecedentes").style.color = "black";
       document.getElementById("legalizacion").style.color = "black";
       document.getElementById("estructura").style.color = "black";
       document.getElementById("objetivos").style.color = "black";
       document.getElementById("monitoreo").style.color = "black";
       document.getElementById("subregionales").style.color = "black";
       document.getElementById("nacionales").style.color = "black";
       document.getElementById("aliados").style.color = "black";
       document.getElementById("publicaciones").style.color = "black";
       document.getElementById("eventos").style.color = "black";
       document.getElementById("webinars").style.color = "black";
       document.getElementById("recursos").style.color = "black";
       document.getElementById("afiliar").style.color = "black";
       document.getElementById("afiliar-link").style.color = "black";
       document.getElementById("footer").style.background = "#FFF7FE";
       document.getElementById("footerc").style.background = "#FFF7FE";
       document.getElementById("footerc").style.color = "#977896";
       document.getElementById("linkedin").style.color = "#977896";
       document.getElementById("facebook").style.color = "#977896";
       document.getElementById("twitter").style.color = "#977896"
       document.getElementById("colaboracion").style.background = "#F1AFF2";
       document.getElementById("compromiso").style.background = "#F1AFF2";
       document.getElementById("igualdad").style.background = "#F1AFF2";
       document.getElementById("responsabilidad").style.background = "#F1AFF2";
       document.getElementById("solidaridad").style.background = "#F1AFF2";
       document.getElementById("transparencia").style.background = "#F1AFF2";
       document.getElementById("etica").style.background = "#F1AFF2";
       document.getElementById("calidad").style.background = "#F1AFF2";
       document.getElementById("equidad").style.background = "#F1AFF2";
       document.getElementById("profesionalismo").style.background = "#F1AFF2";
       document.getElementById("icevig").style.background = "#F1AFF2";
       document.getElementById("ulac").style.background = "#F1AFF2";
       document.getElementById("foal").style.background = "#F1AFF2";
       document.getElementById("holandesa").style.background = "#F1AFF2";
       document.getElementById("readis").style.background = "#F1AFF2";
       document.getElementById("perkins").style.background = "#F1AFF2";
       document.getElementById("container-recursos").style.background = "#F1AFF2";
    });
};
*/
const getFontSize = () => {
   return parseFloat(
       getComputedStyle(document.documentElement).getPropertyValue("--font-size")
   );
};

const increase = (element) => {
    element.addEventListener("click", () => {
       let fontSize = getFontSize();
       document.documentElement.style.setProperty(
           "--font-size",
           `${fontSize * 1.1}px`
       );
    });
};

const decrease = (element) => {
   element.addEventListener("click", () => {
      let fontSize = getFontSize();
      document.documentElement.style.setProperty(
          "--font-size",
          `${fontSize * 0.9}px`
      );
   });
};
setDefaultTheme(window);
contrast(document.getElementById("contrast"));
increase(document.getElementById("increase"));
decrease(document.getElementById("decrease"));
