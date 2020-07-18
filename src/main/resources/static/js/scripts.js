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
        var pathname = window.location.pathname;
        if ((pathname.indexOf("/salao_arrazus/v1/agenda/pessoas/editar/") == 0) || (pathname.indexOf("/salao_arrazus/v1/agenda/fornecedores/editar/") == 0)) {
            $("#tipo-telefone").change(function() {
                var text = $('#tipo-telefone option:selected').val();
                if (text == 'RESIDENCIAL' || text == 'COMERCIAL') {
                    $("#numeroTelefone").inputmask({
                        mask: ['(99) 9999-9999'],
                        keepStatic: true
                    });

                } else if (text == 'CELULAR') {
                    $("#numeroTelefone").inputmask({
                        mask: ['(99) 99999-9999'],
                        keepStatic: true
                    });

                } else {
                    $("#numeroTelefone").inputmask({
                        mask: [''],
                        keepStatic: true
                    });
                }
            });

            var text = $('#tipo-telefone option:selected').val();
            if (text == 'RESIDENCIAL' || text == 'COMERCIAL') {
                $("#numeroTelefone").inputmask({
                    mask: ['(99) 9999-9999'],
                    keepStatic: true
                });

            } else if (text == 'CELULAR') {
                $("#numeroTelefone").inputmask({
                    mask: ['(99) 99999-9999'],
                    keepStatic: true
                });

            } else {
                $("#numeroTelefone").unmask();
            }

            $('#valor').mask('#.##0,00', { reverse: true });
        }
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

    // Ação para botão de Listar todas as Despesas
    $(document).ready(function() {
        var pathname = window.location.pathname;
        if (pathname == "/salao_arrazus/v1/organizacao/fluxo-caixa") {
            var btnSaldoDespesas = document.getElementById("btn-lista-de-despesas");
            btnSaldoDespesas.addEventListener("click", function() {
                var mes = document.getElementById("mes-lista-de-despesas").options[document.getElementById("mes-lista-de-despesas").selectedIndex].value;
                var ano = document.getElementById("ano-lista-de-despesas").options[document.getElementById("ano-lista-de-despesas").selectedIndex].value;
                $.ajax({
                        method: "GET",
                        url: "fluxo-caixa/lista-despesas",
                        data: {
                            "mes": mes,
                            "ano": ano,
                        }
                    })
                    .done(function(msg) {
                        $('.resultado-lista-de-despesas').children().remove();
                        for (var i = 0; i < msg.length; i++) {
                            var resposta = JSON.parse(JSON.stringify(msg))[i];
                            $('.resultado-lista-de-despesas').append("<tr>");
                            $('.resultado-lista-de-despesas').append("<td scope='row'>" + resposta.descricao + "</td>");
                            $('.resultado-lista-de-despesas').append("<td> R$ " + resposta.valor + "</td>");
                            $('.resultado-lista-de-despesas').append("<td>" + moment(resposta.data).format('DD/MM/YYYY') + "</td>");
                            $('.resultado-lista-de-despesas').append("</tr>");
                        }
                    });
                $.ajax({
                        method: "GET",
                        url: "fluxo-caixa/saldo-despesas",
                        data: {
                            "mes": mes,
                            "ano": ano,
                        }
                    })
                    .done(function(msg) {
                        document.getElementById("p-saldo-de-despesas").textContent = "- Saldo: R$ " + msg;
                    });
            });
        }
    });

    // Ação para botão de Listar todas as Receitas
    $(document).ready(function() {
        var pathname = window.location.pathname;
        if (pathname == "/salao_arrazus/v1/organizacao/fluxo-caixa") {
            var btnSaldoDespesas = document.getElementById("btn-lista-de-receitas");
            btnSaldoDespesas.addEventListener("click", function() {
                var mes = document.getElementById("mes-lista-de-receitas").options[document.getElementById("mes-lista-de-receitas").selectedIndex].value;
                var ano = document.getElementById("ano-lista-de-receitas").options[document.getElementById("ano-lista-de-receitas").selectedIndex].value;
                $.ajax({
                        method: "GET",
                        url: "fluxo-caixa/lista-receitas",
                        data: {
                            "mes": mes,
                            "ano": ano,
                        }
                    })
                    .done(function(msg) {
                        $('.resultado-lista-de-receitas').children().remove();
                        for (var i = 0; i < msg.length; i++) {
                            var resposta = JSON.parse(JSON.stringify(msg))[i];

                            $('.resultado-lista-de-receitas').append("<tr>");
                            $('.resultado-lista-de-receitas').append("<td scope='row'>" + resposta.descricao + "</td>");
                            $('.resultado-lista-de-receitas').append("<td> R$ " + resposta.valor + "</td>");
                            $('.resultado-lista-de-receitas').append("<td>" + moment(resposta.data).format('DD/MM/YYYY') + "</td>");
                            $('.resultado-lista-de-receitas').append("</tr>");
                        }
                    });
                $.ajax({
                        method: "GET",
                        url: "fluxo-caixa/saldo-receitas",
                        data: {
                            "mes": mes,
                            "ano": ano,
                        }
                    })
                    .done(function(msg) {
                        document.getElementById("p-saldo-de-receitas").textContent = "- Saldo: R$ " + msg;
                    });
            });
        }
    });


    $(document).ready(function() {
        var pathname = window.location.pathname;
        if (pathname == "/salao_arrazus/v1/organizacao/fluxo-caixa") {
            var receitas;
            $.ajax({
                    method: "GET",
                    url: "fluxo-caixa/saldo-receitas",
                    data: {
                        "mes": 0,
                        "ano": 0,
                    }
                })
                .done(function(msg) {
                    receitas = msg;
                    document.getElementById("p-total-receita").textContent = "- Receitas: R$ " + msg;
                });
            $.ajax({
                    method: "GET",
                    url: "fluxo-caixa/saldo-despesas",
                    data: {
                        "mes": 0,
                        "ano": 0,
                    }
                })
                .done(function(msg) {
                    document.getElementById("p-total-despesa").textContent = "- Despesas: R$ " + msg;
                });
            $.ajax({
                    method: "GET",
                    url: "fluxo-caixa/lista-receitas",
                    data: {
                        "mes": 0,
                        "ano": 0,
                    }
                })
                .done(function(msg) {
                    var resposta = JSON.parse(JSON.stringify(msg))[0];
                    var date = new Date(resposta.data);
                    var a = moment(date, 'D/M/YYYY');
                    var b = moment(new Date(), 'D/M/YYYY');

                    var diffDays = b.diff(a, 'months');
                    console.log("aqui: " + diffDays);
                    var valorTotal = 0;
                    for (var i = 0; i < msg.length; i++) {
                        var resp = JSON.parse(JSON.stringify(msg))[i];
                        valorTotal += parseFloat(resp.valor);
                    }
                    document.getElementById("p-media-receita").textContent = "- Receita média: R$ " + valorTotal / diffDays;
                    if (diffDays > 0) {}

                });

            $.ajax({
                    method: "GET",
                    url: "fluxo-caixa/lista-despesas",
                    data: {
                        "mes": 0,
                        "ano": 0,
                    }
                })
                .done(function(msg) {
                    var resposta = JSON.parse(JSON.stringify(msg))[0];
                    var date = new Date(resposta.data);
                    var a = moment(date, 'D/M/YYYY');
                    var b = moment(new Date(), 'D/M/YYYY');
                    var diffDays = b.diff(a, 'months');
                    if (diffDays > 0) {
                        var valorTotal = 0;
                        for (var i = 0; i < msg.length; i++) {
                            var resposta = JSON.parse(JSON.stringify(msg))[i];
                            valorTotal += parseFloat(resposta.valor);
                        }
                        document.getElementById("p-media-despesa").textContent = "- Despesa média: R$ " + valorTotal / diffDays;
                    }

                });
        }
    });

    $(document).ready(function() {
        var pathname = window.location.pathname;
        if (pathname == "/salao_arrazus/v1/calendario/servicos/hoje") {
            var b = moment().format('MM/DD/YYYY');
            document.getElementById("titulo-data-hoje").textContent = "Data de hoje: " + b;
        }
    });


})(jQuery);