function changeLanguage(lang) {
    $("#lang").val(lang);
    $("#formulario").trigger("submit");
}