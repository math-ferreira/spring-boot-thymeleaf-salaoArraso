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

    //masks
    $(document).ready(function() {
        $('#phone-number').mask('0000-0000');
        $('#valor').mask('#.##0,00', { reverse: true });
    });

    $(document).ready(function() {
        if ($('#valor').val() == 0) {
            $('#valor').val("");
        }
    });

    $(document).ready(function() {
        if ($('#cliente').val() == null) {
            var pathname = window.location.pathname;
            if (pathname == "/salao_arrazus/v1/calendario/servicos/adicionar") {
                $('#btn-salvar').prop("disabled", true);
                $('#btn-salvar').attr('title', 'Não é possivel inserir, não há contatos na agenda');
            }
        }
    });

    $("#btn-confirmar").on("click", function(e) {
        $('#modalConfirmar').modal('toggle');
    });

    $("#btn-salvar").on("click",
        function(e) {
            var pathname = window.location.pathname;
            console.log("aqui: " + pathname);
            if ((
                    pathname.indexOf("/salao_arrazus/v1/calendario/servicos/editar") == 0 ||
                    pathname.indexOf("/salao_arrazus/v1/calendario/servicos/adicionar") == 0 ||
                    pathname.indexOf("/salao_arrazus/v1/organizacao/estoque/adicionar") == 0 ||
                    pathname.indexOf("/salao_arrazus/v1/organizacao/estoque/editar/") == 0
                ) &&
                $('#valor').val() != "" &&
                $('#data').val() != ""
            ) {
                $('#valor').val($('#valor').val().replace(/\./g, '').replace(/\,/g, '.'));
                alert("Dados Salvos com sucesso");
            } else if ((pathname.indexOf("/salao_arrazus/v1/agenda/pessoas/editar/") == 0 ||
                    pathname.indexOf("/salao_arrazus/v1/agenda/pessoas/adicionar") == 0) &&
                $("#nomePessoa").val() != '' &&
                $("#numeroTelefone").val() != '' &&
                $("#bairro").val() != '' &&
                $("#cidade").val() != '') {
                alert("Dados Salvos com sucesso");
            } else if (pathname.indexOf("/salao_arrazus/v1/organizacao/estoque/adicionar") == 0 &&
                $("#descricaoProduto").val() != '' &&
                $("#valor").val() != '' &&
                $("#data").val() != '') {
                alert("Dados Salvos com sucesso");
            } else if ((pathname.indexOf("/salao_arrazus/v1/agenda/fornecedores/adicionar") == 0 ||
                    pathname.indexOf("/salao_arrazus/v1/agenda/fornecedores/editar/") == 0) &&
                $("#nomeFornecedor").val() != '' &&
                $("#ramoFornecedor").val() != '' &&
                $("#numeroTelefone").val() != '' &&
                $("#bairro").val() != '' &&
                $("#cidade").val() != ''
            ) {
                alert("Dados Salvos com sucesso");
            }
        });




    /*    btn.addEventListener("click", function() {
            $.ajax({
                    method: "GET",
                    url: "https://jsonplaceholder.typicode.com/posts"
                })
                .done(function(msg) {
                    for (var i = 0; i < msg.length; i++) {
                        var resposta = JSON.parse(JSON.stringify(msg))[i];
                        $(".ul-teste").append("<li> UserId: " + resposta.userId + "</li>");
                        $(".ul-teste").append("<li> Id: " + resposta.id + "</li>");
                        $(".ul-teste").append("<li> Title: " + resposta.title + "</li>");
                        $(".ul-teste").append("<li> Body: " + resposta.body + "</li>");
                        $(".ul-teste").append("<br>");

                    }
                });
        }); */

    var btnListaDeReceitas = document.getElementById("btn-lista-de-receitas");
    btnListaDeReceitas.addEventListener("click", function() {
        var mes = document.getElementById("mes-lista-de-receitas").options[document.getElementById("mes-lista-de-receitas").selectedIndex].value;
        var ano = document.getElementById("ano-lista-de-receitas").options[document.getElementById("ano-lista-de-receitas").selectedIndex].value;;
        $.ajax({
                method: "GET",
                url: "fluxo-caixa/saldo-receitas",
                data: {
                    "mes": mes,
                    "ano": ano,
                }
            })
            .done(function(msg) {
                document.getElementById("p-lista-de-receitas").textContent = "Saldo: R$ " + msg;
            });
    });


    var btnListaDeReceitas = document.getElementById("btn-lista-de-despesas");
    btnListaDeReceitas.addEventListener("click", function() {
        var mes = document.getElementById("mes-lista-de-despesas").options[document.getElementById("mes-lista-de-despesas").selectedIndex].value;
        var ano = document.getElementById("ano-lista-de-despesas").options[document.getElementById("ano-lista-de-despesas").selectedIndex].value;;
        $.ajax({
                method: "GET",
                url: "fluxo-caixa/saldo-despesas",
                data: {
                    "mes": mes,
                    "ano": ano,
                }
            })
            .done(function(msg) {
                document.getElementById("p-lista-de-despesas").textContent = "Saldo: R$ " + msg;
            });
    });

})(jQuery);