/*!
 * Start Bootstrap - SB Admin v6.0.0 (https://startbootstrap.com/templates/sb-admin)
 * Copyright 2013-2020 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-sb-admin/blob/master/LICENSE)
 */
(function($) {
    "use strict";
    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the
    // DOM element is the absolute path
    $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
        if (this.href === path) {
            $(this).addClass("active");
        }
    });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });

    $(document).ready(function() {
        $('#phone-number').mask('0000-0000');
    });




    $("#btn-confirmar").on("click", function(e) {
        $('#modalConfirmar').modal('toggle');
    });

    $("#btn-salvar").on("click",
        function(e) {
            if ($("#nomePessoa").val() != '' &&
                $("#numeroTelefone").val() != '' &&
                $("#bairro").val() != '' &&
                $("#cidade").val() != '') {
                alert("Dados Salvos com sucesso");
            }
        });

})(jQuery);

//$("#valor").mask("R$ 9999", { autoclear: false });